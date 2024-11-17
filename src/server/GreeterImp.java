package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Implementation of the RMI Greeter server interface.
 *
 * @author Michael J. May
 */
public class GreeterImp extends UnicastRemoteObject implements Greeter {

    /**
     * Number of people greeted so far
     */
    int count;
    /**
     * The list of names already greeted
     */
    ArrayList<String> names;

    /**
     * Sets up the greeter implementation
     * @throws RemoteException
     */
    public GreeterImp() throws RemoteException {
        super();
        count = 0;
        names = new ArrayList<>();
    }

    /**
     * Returns the number of people greeted so far
     * @return The number of people greeted so far
     * @throws RemoteException
     */
    @Override
    public int countGreeted() throws RemoteException {
        return count;
    }

    /**
     * Greets multiple people.
     * @param s List of people to greet divided by ;
     * @return An array of greetings for people
     * @throws RemoteException
     */
    @Override
    public String[] greetPeople(String s) throws RemoteException {
        String[] parts = s.split(";");
        String[] results = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            results[i] = greetPerson(parts[i]);
        }
        return results;
    }

    /**
     * Greets a single person
     * @param s Name of the person to greet
     * @return A greeting for the person.  Hello there if it's a new name.  Welcome back if it's a name we've seen before
     * @throws RemoteException
     */
    @Override
    public String greetPerson(String s) throws RemoteException {
        String result;
        if (names.contains(s)) {
            result = "Welcome back " + s + "!";
        } else  {
            result = "Hello there " + s + "!";
            names.add(s);
        }
        count++;
        System.out.println("Greeted one new person");
        return result;
    }
}
