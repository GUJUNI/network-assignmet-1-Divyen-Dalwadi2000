NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
//q-1(B) write a java code for TCP in java to send number and check whether it is palindrome or not

import java.io.*;
import java.net.*;

public class PalindromeClient {

    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 5000;
        
        try (
            Socket socket = new Socket(hostname, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            System.out.print("Enter a number: ");
            userInput = stdIn.readLine();
            out.println(userInput);
            System.out.println("Sent: " + userInput);
            String response = in.readLine();
            System.out.println("Received: " + response);
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + hostname);
            System.exit(1);
        }
    }
}



//  javac .\PalindromeClient.java
//  java PalindromeClient        

// Enter a number: 121
// Sent: 121
// Received: The number is a palindrome.