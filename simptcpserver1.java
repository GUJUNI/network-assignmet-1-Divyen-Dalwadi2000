NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
//q-1(A) write a java code for TCP in java to send number and check whether it is palindrome or not

package one;

import java.io.*;
import java.net.*;

public class PalindromeServer {

    public static void main(String[] args) throws IOException {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress().getHostName());
                try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received: " + inputLine);
                        String response;
                        if (isPalindrome(inputLine)) {
                            response = "The number is a palindrome.";
                        } else {
                            response = "The number is not a palindrome.";
                        }
                        out.println(response);
                    }
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(1);
        }
    }
    
    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


//  javac  PalindromeServer.java    
//  java PalindromeServer

// Server listening on port 5000
