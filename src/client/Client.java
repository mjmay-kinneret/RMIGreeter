package client;

import server.Greeter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client for the RMI Greeter example.
 *
 * @author Michael J. May
 */
public class Client {

    /**
     * Starts the Greeter client.  Needs two parameters - remoteHost and remote object name
     * @param args Command line arguments.  Must be hostName followed by remote object name (ex. 127.0.0.1 greet)
     */
    public static void main(String[] args) {
        String remoteHost = args[0];
        String remoteObjectName = args[1];

        Greeter greetingServer;
        try {
            Registry registry = LocateRegistry.getRegistry(remoteHost); // args[0]
            greetingServer = (Greeter) registry.lookup(remoteObjectName); //args[1]

        } catch (Exception rex) {
            System.out.println("Error connecting to remote object: " + rex.getMessage());
            return;
        }

        System.out.println("Successfully connected to server.");
        System.out.print("Enter a name or names to greet (; delimits). Blank to quit: ");
        BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.print("Enter a people to greet delimited by ; (blank to quit): ");
                String nameToGreet = brIn.readLine();

                if (nameToGreet.trim().length() == 0) {
                    break;
                }

                if (nameToGreet.contains(";")) {
                    String[] greetings = greetingServer.greetPeople(nameToGreet);
                    for (String g : greetings) {
                        System.out.println(g);
                    }
                } else {
                    String greeting = greetingServer.greetPerson(nameToGreet);
                    System.out.println(greeting);
                }

                System.out.println("Greeted " + greetingServer.countGreeted() + " people so far");
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("Error in communicating with server: " + ex.getMessage());
            return;
        }

        System.out.println("Bye!");
    }
}
