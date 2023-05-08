NAME 	   : DALWADI DIVYEN
ROLLNO     : 06
COURSE     : MCA-2
SUBJECT    : ADVANCE NETWORKING
ASSIGNMENT : PRACTICAL ASSIGNMENT
*************************************************************************************
// Q-2 (A) write a java code for TCP  Multithreding in java to send String and return the reverse of string and length of string
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started");
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");
                Thread t = new ClientHandler(client);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("Received message: " + message);

            StringBuilder reversedMessage = new StringBuilder(message).reverse();
            out.println("Reversed message: " + reversedMessage.toString());
            out.println("Length of message: " + message.length());

            in.close();
            out.close();
            client.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// javac .\TCPServer.java
//  java TCPServer

// Server started
// Client connected
// Received message: Hello, world!
// Connection closed