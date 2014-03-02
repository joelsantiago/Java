import java.io.*;
import java.net.*;

/**
 *  CLI arguments: java UDPserver PortNumber
 */
public class UDPserver {
    public static void main(String args[]) throws Exception {

        int portNumber = Integer.parseInt(args[0]);

        try {
            DatagramSocket serverSocket = new DatagramSocket(portNumber);

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {

                receiveData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                System.out.println("Waiting for datagram packet");

                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());

                InetAddress IPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                System.out.println("From: " + IPAddress + ":" + port);
                System.out.println("Message: " + sentence);

                String capitalizedSentence = sentence.toUpperCase();

                sendData = capitalizedSentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

                serverSocket.send(sendPacket);
            }
        } catch (SocketException ex) {
            System.out.println("UDP Port " + portNumber + " is occupied");
            System.exit(1);
        }
    }
}
