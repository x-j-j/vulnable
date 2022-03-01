import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface User extends Remote {
    String name(String name) throws RemoteException;
    void say(String say) throws RemoteException;
    void dowork(Object work) throws RemoteException;
}

