package base;

import java.io.*;
import java.util.Arrays;

public class learnIO {
    //https://www.cnblogs.com/furaywww/p/8849850.html
    private String getPath(){
        File f = new File("");
//        String path = learnio.class.getResource("\\").getPath();// /C:/Users/HASEE/Desktop/downloads/vulnable/target/classes/base/%5c
//        String path = learnio.class.getResource("").getPath();// /C:/Users/HASEE/Desktop/downloads/vulnable/target/classes/base/
//        String path = new File("").getCanonicalPath();// C:\Users\HASEE\Desktop\downloads\vulnable
//        String path = System.getProperty("java.class.path");// C:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar;C:\Users\HASEE\Desktop\downloads\vulnable\target\classes;C:\Users\HASEE\Desktop\downloads\vulnable\commons-collections-3.1.jar;C:\Users\HASEE\.m2\repository\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2020.1\lib\idea_rt.jar
//        String sep = File.separator;// \\
        String path = System.getProperty("user.dir");// C:\Users\HASEE\Desktop\downloads\vulnable
        System.out.println(path);
        return path;
    }
    private File getFile(){
        //File只对文件属性操作，不修改内容
        File parent = new File("C:");
        File f = new File(parent,"Windows");
        String path = getPath();
        return new File(path+"..\\files\\test.txt");
    }
    /**字节流分为缓存，内存，外存
     In是向内存写入，Out是向外存写出
     */
    private void byteFlow() throws IOException {
        //In
        File target = getFile();
        InputStream in = new FileInputStream(target);
        in.read();//第一个字节
        byte[] buffer = new byte[10];
        in.read(buffer);//10个字节
        in.read(buffer, 0, 3);//3个字节
        System.out.println(Arrays.toString(buffer));
        in.close();

        //Out
        OutputStream out = new FileOutputStream(target);
        out.write(65);//A
        out.write("Aa".getBytes());
        out.write("ABCDEF".getBytes(), 1, 5);
        out.flush();//缓存刷新写入文件
        out.close();

        //文件复制
        File target2 = getFile();
        int len = -1;
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        out.close();
        in.close();

    }
    private void charFlow(){}
    /**包装流**/
    private void packagingFlow() throws IOException {
        InputStream in = new FileInputStream(getFile());
        OutputStream out = new FileOutputStream(getFile());
        /**缓冲流**/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(getPath()));
        /**转换流**/
        //字符流转换成字节流
        //FileWriter和FileReader继承他们使用固定编码
        Reader rd = new InputStreamReader(in,"GBK");
        Writer wt = new OutputStreamWriter(out,"utf-8");
        //以下三个等同
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));//默认字符集。
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"GBK");//指定GBK字符集。
//        FileReader fr = new FileReader("a.txt");
        /**内存流**/
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write("chars".getBytes());
        byte[] temp = bos.toByteArray();
        /**对象流**/
    }
    public static void main(String[] args) throws IOException {
//        System.out.println("ABC".getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write("chars".getBytes());
        byte[] temp = bos.toByteArray();
        System.out.println(new String(temp,0,temp.length));

//        ByteArrayInputStream bis = new ByteArrayInputStream();

    }
}
