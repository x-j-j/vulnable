package base.proxy.dynamicProxy.javassist;

import javassist.*;

import java.lang.reflect.Constructor;

public class Run {
//    https://blog.csdn.net/qiushisoftware/article/details/103051007
    public static void main(String[] args) throws Exception {
        createProxy();
    }

    /*
     * 手动创建字节码
     */
    private static void createProxy() throws Exception
    {
        ClassPool pool = ClassPool.getDefault();

        CtClass cc = pool.makeClass("base.proxy.dynamicProxy.stationProxy");

        //设置接口
        CtClass interface1 = pool.get("base.proxy.dynamicProxy.javassist.TicketService");
        cc.setInterfaces(new CtClass[]{interface1});

        //设置Field
        CtField field = CtField.make("private base.proxy.dynamicProxy.javassist.Station station;", cc);

        cc.addField(field);

        CtClass stationClass = pool.get("com.foo.proxy.Station");
        CtClass[] arrays = new CtClass[]{stationClass};
        CtConstructor ctc = CtNewConstructor.make(arrays,null,CtNewConstructor.PASS_NONE,null,null, cc);
        //设置构造函数内部信息
        ctc.setBody("{this.station=$1;}");
        cc.addConstructor(ctc);

        //创建收取手续 takeHandlingFee方法
        CtMethod takeHandlingFee = CtMethod.make("private void takeHandlingFee() {}", cc);
        takeHandlingFee.setBody("System.out.println(\"收取手续费，打印发票。。。。。\");");
        cc.addMethod(takeHandlingFee);

        //创建showAlertInfo 方法
        CtMethod showInfo = CtMethod.make("private void showAlertInfo(String info) {}", cc);
        showInfo.setBody("System.out.println($1);");
        cc.addMethod(showInfo);

        //sellTicket
        CtMethod sellTicket = CtMethod.make("public void sellTicket(){}", cc);
        sellTicket.setBody("{this.showAlertInfo(\"××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××\");"
                + "station.sellTicket();"
                + "this.takeHandlingFee();"
                + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}");
        cc.addMethod(sellTicket);

        //添加inquire方法
        CtMethod inquire = CtMethod.make("public void inquire() {}", cc);
        inquire.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，问询服务不会收取任何费用，本问询信息仅供参考，具体信息以车站真实数据为准！××××\");"
                + "station.inquire();"
                + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}"
        );
        cc.addMethod(inquire);

        //添加widthraw方法
        CtMethod withdraw = CtMethod.make("public void withdraw() {}", cc);
        withdraw.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，退票除了扣除票额的20%外，本代理处额外加收2元手续费！××××\");"
                + "station.withdraw();"
                + "this.takeHandlingFee();}"
        );
        cc.addMethod(withdraw);

        //获取动态生成的class
        Class c = cc.toClass();
        //获取构造器
        Constructor constructor= c.getConstructor(Station.class);
        //通过构造器实例化
        TicketService o = (TicketService)constructor.newInstance(new Station());
        o.inquire();

        cc.writeFile("D://test");
    }
}
