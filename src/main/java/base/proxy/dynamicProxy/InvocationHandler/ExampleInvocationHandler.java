package base.proxy.dynamicProxy.InvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

//弊端：代理的类必须存在某个接口(类或者函数等),无法动态生成接口,解决办法使用cglab
public class ExampleInvocationHandler implements InvocationHandler {
    protected Map map;
    public ExampleInvocationHandler(Map map){
        this.map = map;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().compareTo("get") == 0){
            System.out.println("after invoke");
        }
//        System.out.println(new String(String.valueOf(method))+"\n");
        return method.invoke(this.map, args);
    }
}
