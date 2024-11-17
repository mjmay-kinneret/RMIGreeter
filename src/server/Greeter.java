package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for RMI greeting server
 *
 * @author Michael J. May
 */
public interface Greeter extends Remote {
    /**
     * Counts the number of people greeted so far
     * @return Count of people greeted so far.
     */
    int countGreeted() throws RemoteException;
    /**
     * Sends back of a list of greeting for multiple people
     * @param s List of people to greet divided by ;
     * @return Array of greetings
     */
    String[] greetPeople(String s) throws RemoteException;
    /**
     * Greets a single person
     * @param s Name of the person to greet
     * @return A greeting for the person
     * @throws RemoteException
     */
    String greetPerson (String s) throws RemoteException;
}
