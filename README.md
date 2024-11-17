# RMI Greeter example
## Michael J. May, Kinneret College on the Sea of Galilee

This code shows a simple Hello World level introduction to Java RMI.  We show how the classes and interfaces of RMI are used to make a simple server that publishes a Greeter service over RMI.  The client and server both have command line interfaces and enable multi-threaded unsecured access.

The example shows the sending of objects across RMI (a String[]) as well as state preservation between calls.  The server records how many people have been greeted so far and also which names have been sent previously.

The example here is based on a Java RMI example I found in a Java textbook a while back.  It's also remniscient of the Java RMI getting started example from the Java Trails tutorials (https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/hello/hello-world.html)
