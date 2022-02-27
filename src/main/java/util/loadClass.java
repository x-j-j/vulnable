package util;

import evalclass.HelloTemplatesImpl;
import javassist.ClassPool;
import javassist.CtClass;

public class loadClass {
    public static byte[] getBytesCode()throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass clazz = pool.get(HelloTemplatesImpl.class.getName());
        return clazz.toBytecode();
    }
}

