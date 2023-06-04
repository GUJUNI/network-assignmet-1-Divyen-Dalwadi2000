
// Q-5 ) Write a JAVA Program That Performs Encryption/Decryption. 
import java.util.Scanner;

public class CaesarCipher {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the message you want to encrypt: ");
        String message = sc.nextLine();
        System.out.print("Enter the key for encryption: ");
        int key = sc.nextInt();
        
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);
        
        System.out.print("Enter the message you want to decrypt: ");
        sc.nextLine();
        String encrypted = sc.nextLine();
        System.out.print("Enter the key for decryption: ");
        int decryptionKey = sc.nextInt();
        
        String decryptedMessage = decrypt(encrypted, decryptionKey);
        System.out.println("Decrypted message: " + decryptedMessage);
        
        sc.close();
    }
    
    public static String encrypt(String message, int key) {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(((ch - 'a') + key) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(((ch - 'A') + key) % 26 + 'A');
            }
            encrypted += ch;
        }
        return encrypted;
    }
    
    public static String decrypt(String encrypted, int key) {
        String decrypted = "";
        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(((ch - 'a') - key + 26) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(((ch - 'A') - key + 26) % 26 + 'A');
            }
            decrypted += ch;
        }
        return decrypted;
    }
}




// Enter the message you want to encrypt: Hello, World!
// Enter the key for encryption: 3
// Encrypted message: Khoor, Zruog!

// Enter the message you want to decrypt: Khoor, Zruog!
// Enter the key for decryption: 3
// Decrypted message: Hello, World!
