package base.proxy.dynamicProxy.InvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

//https://blog.csdn.net/qiushisoftware/article/details/103083238?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_antiscan&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_antiscan&utm_relevant_index=2
public class learnproxy {
    public static void main(String[] args) {
        Map proxyMap = (Map) Proxy.newProxyInstance(Map.class.getClassLoader(),new Class[]{Map.class},new ExampleInvocationHandler(new HashMap()));
        proxyMap.put("hello","world");
        System.out.println(proxyMap.get("hello"));
    }
}