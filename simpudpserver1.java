NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
// Q-3(A) rite a java code for UDP in java to send String and check How many VOWEL in the String

import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);

            String message = "Hello, welcome to UDP programming!";
            InetAddress clientAddress = InetAddress.getLocalHost();
            int clientPort = 9877;
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
