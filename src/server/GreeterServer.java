package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Server for the RMI Greeter example.
 *
 * @author Michael J. May
 */
public class GreeterServer {
    public static void main(String[] args) throws RemoteException {
        // make a greeter object
        GreeterImp greeter = new GreeterImp();
        // get a hook to the local registry
        Registry registry = LocateRegistry.createRegistry(1099);
        // now bind to it to the name ‘greet’
        registry.rebind("greet", greeter);
        System.out.println("Bound the object to rmi://" + "127.0.0.1" +"/greet  Ready for connections.");
    }
}
