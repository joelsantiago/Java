import java.io.*;
import java.net.*;

/**
 *  CLI arguments: java UDPclient HostName PortNumber
 */
public class UDPclient {
    public static void main(String args[]) throws Exception {

        String serverHostname = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(serverHostname);
            System.out.println("Attempting to connect to " + IPAddress + ") via UDP port " + portNumber);
            System.out.println("Enter \"Quit\" to exit program");

            while (true) {
                byte[] sendData = new byte[1024];
                byte[] receiveData = new byte[1024];

                System.out.print("Enter Message: ");
                String sentence = inFromUser.readLine();

                if (sentence.equals("Quit"))
                    break;

                sendData = sentence.getBytes();

                System.out.println("Sending data to " + sendData.length + " bytes to server.");
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, portNumber);

                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                System.out.println("Waiting for return packet");
                clientSocket.setSoTimeout(10000);

                try {
                    clientSocket.receive(receivePacket);
                    String modifiedSentence = new String(receivePacket.getData());

                    InetAddress returnIPAddress = receivePacket.getAddress();

                    int port = receivePacket.getPort();

                    System.out.println("From server at: " + returnIPAddress + ":" + port);
                    System.out.println("Message: " + modifiedSentence);
                } catch (SocketTimeoutException ste) {
                    System.out.println("Timeout Occurred: Packet assumed lost");
                }
                System.out.print("\n");
            }

            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}