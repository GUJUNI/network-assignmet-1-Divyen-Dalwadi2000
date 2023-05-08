// Q-6) Write a program  in java to compute a message digest for a file of any type and any size. 

import java.io.*;
import java.security.*;

public class MessageDigest {
    public static void main(String[] args) {
        try {
            // Create a MessageDigest object with the SHA-256 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Prompt the user to enter the file path
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the file path: ");
            String filePath = br.readLine();
            
            // Compute the message digest for the file
            FileInputStream fis = new FileInputStream(filePath);
            byte[] dataBytes = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, bytesRead);
            }
            byte[] digestBytes = md.digest();
            
            // Convert the message digest to a hexadecimal string
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digestBytes.length; i++) {
                sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String messageDigest = sb.toString();
            
            // Print the message digest
            System.out.println("Message digest: " + messageDigest);
            
            // Close the file input stream
            fis.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error computing message digest: " + e.getMessage());
        }
    }
}


// Enter the file path: /path/to/file/example.txt
// Message digest: e8c09c12d49a47f9a9f74fc6330cfc5b5d5b1e8c9120b497c3d6325db5d5b5c
