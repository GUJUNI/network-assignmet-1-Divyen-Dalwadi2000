NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
// Q-2 (B) write a java code for TCP  Multithreding in java to send String and return the reverse of string and length of string
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "Hello, world!";
            out.println(message);

            String reversedMessage = in.readLine();
            System.out.println(reversedMessage);
            String lengthMessage = in.readLine();
            System.out.println(lengthMessage);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//  javac TCPClient.java
//  java TCPClient

// Reversed message: !dlrow ,olleH
// Length of message: 13