NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
// Q-3(B) write a java code for UDP in java to send String From a server and check the Client side How many VOWEL in the String
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(9877);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String message = new String(receivePacket.getData()).trim();

            int vowelCount = 0;
            for (char c : message.toCharArray()) {
                if ("AEIOUaeiou".indexOf(c) != -1) {
                    vowelCount++;
                }
            }

            System.out.println("Received message: " + message);
            System.out.println("Number of vowels: " + vowelCount);

            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



// Received message: Hello, welcome to UDP programming!
// Number of vowels: 10
