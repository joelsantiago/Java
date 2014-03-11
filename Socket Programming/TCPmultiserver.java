import java.net.*;
import java.io.*;

/**
 *  CLI arguments: java TCPmultiserver PortNumber
 */
public class TCPmultiserver extends Thread {
    protected Socket clientSocket;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        int portNumber = Integer.parseInt(args[0]);

        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Connection Socket Created");
            try {
                while (true) {
                    System.out.println("Waiting for connection");
                    new TCPmultiserver(serverSocket.accept());
                }
            } catch (IOException e) {
                System.err.println("Accept failed");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + portNumber);
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: " + portNumber);
                System.exit(1);
            }
        }
    }

    private TCPmultiserver(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run() {
        System.out.println("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);

                if (inputLine.equals("Bye"))
                    break;
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Problem with communication server");
            System.exit(1);
        }
    }
}