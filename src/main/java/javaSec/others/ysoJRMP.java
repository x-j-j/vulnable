import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import sun.rmi.server.UnicastRef;

public class ysoJRMP {
    public static void main(String[] args) throws Exception{
        Registry r = LocateRegistry.getRegistry("127.0.0.1", 12345);
        r.list();
//        r.bind("user",new User());
    }
}
