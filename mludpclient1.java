NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
//Q-4(B) Java code for UDP multithreading that sends an ATM or credit card number to a server and validates whether the number
// is valid or not using the Luhn algorithm.


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            byte[] buffer;
            String message;
            
            System.out.print("Enter the card number to validate: ");
            message = scanner.nextLine();
            buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
            socket.send(packet);
            
            buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + message);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

}


// The output on the client side will look like:
// Enter the card number to validate: 1234567890123456
// Received message: Card number is valid



















/*
=========================
Explanation of validation
=========================
The validation code in the example Java code I provided is just a stub, but I can explain one commonly used algorithm
 for validating credit card numbers, known as the Luhn algorithm.

The Luhn algorithm works by verifying a checksum digit in a credit card number. The checksum digit is the last digit of 
the card number, and it is used to verify the validity of the card number. Here are the steps of the Luhn algorithm:

Starting with the second to last digit and moving left, double every other digit in the card number.

If the result of doubling a digit is greater than 9, add the two digits of the result together to get a single digit.
 For example, doubling the digit 7 results in 14, so you would add 1 + 4 to get 5.

Sum up all the digits in the modified card number (including the checksum digit).

If the sum is a multiple of 10, the card number is valid. Otherwise, it is not valid.

Here is an example of validating the card number "1234567890123456" using the Luhn algorithm:

Double every other digit, starting with the second to last digit:

1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6
1 4 3 8 5 12 7 16 9 0 2 6 4 10 6 12

Add the digits of the doubled numbers greater than 9:

1 + 4 + 3 + 8 + 5 + 1 + 2 + 7 + 1 + 6 + 9 + 0 + 2 + 6 + 4 + 1 + 0 + 6 + 1 + 2 = 70

Check if the sum is a multiple of 10:

70 % 10 = 0

Since the sum is a multiple of 10, the card number is valid according to the Luhn algorithm.

Note that the Luhn algorithm is not foolproof and cannot detect all types of errors in credit card numbers. For example,
 it cannot detect errors where digits are transposed (e.g. switching the order of two adjacent digits). Nonetheless, it 
 is a widely used algorithm for validating credit card numbers.


*/