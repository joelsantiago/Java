import java.io.*;
import java.net.*;


/**
 * CLI arguments: java TCPmulticlient HostName PortNumber
 */
public class TCPmulticlient {
    public static void main(String[] args) throws IOException {

        String serverHostname = args[0];
        int portNumber = Integer.parseInt(args[1]);

        System.out.println("Attempting to connect to host " + serverHostname + " on port " + portNumber);

        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            clientSocket = new Socket(serverHostname, portNumber);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type Message (\"Bye\" to quit)");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            if (userInput.equals("Bye"))
                break;

            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        clientSocket.close();
    }
}