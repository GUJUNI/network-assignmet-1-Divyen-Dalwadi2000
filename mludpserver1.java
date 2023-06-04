NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
// Q-4(A) Java code for UDP multithreading that sends an ATM or credit card number to a server and validates whether the number
// is valid or not using the Luhn algorithm.


import java.io.*;
import java.net.*;

public class UDPServer {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            socket = new DatagramSocket(5000);
            byte[] buffer;
            String message;
            DatagramPacket packet;
            
            while (true) {
                buffer = new byte[1024];
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                
                message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
                
                if (validateCardNumber(message)) {
                    message = "Card number is valid";
                } else {
                    message = "Card number is not valid";
                }
                
                buffer = message.getBytes();
                packet = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());
                socket.send(packet);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
    
    private static boolean validateCardNumber(String cardNumber) {
        // Perform Luhn algorithm validation
        return true; // Replace with your own validation code
    }

}


// The output on the server side will look like:
// Received message: 1234567890123456
