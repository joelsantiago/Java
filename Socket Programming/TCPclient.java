import java.io.*;
import java.net.*;

public class TCPclient {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String("joelsantiago.co");

        if (args.length > 0)
            serverHostname = args[0];
        System.out.println("Attempting to connect to host " + serverHostname + " on port 50500");

        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            clientSocket = new Socket(serverHostname, 50500);
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

        System.out.print("input: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
            System.out.print("input: ");
        }

        out.close();
        in.close();
        stdIn.close();
        clientSocket.close();
    }
}
