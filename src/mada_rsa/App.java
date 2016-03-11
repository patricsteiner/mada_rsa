package mada_rsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * FHNW
 * Mathematik für die Datenkommunikation
 * Klasse 2iCa
 * FS 2016
 * Programmieraufgabe RSA
 * 
 * @author Patric Steiner <patric.steiner@students.fhnw.ch>
 */

public class App {
	
    public static void main(String[] args) {
    	//task1();
    	//task2();
    	//task3();
    	//task4();
    }
    
    // Task #1: Generate random public and private key, save to sk.txt and pk.txt
    public static void task1() {
    	 KeyPair keyPair = new KeyPair();
         writeToFile("sk.txt", keyPair.getPrivateKey().toString());
         writeToFile("pk.txt", keyPair.getPublicKey().toString());
    }
    
    public static void task2() {
    	PublicKey publicKey = new PublicKey("pk.txt");
    	String message = readFromFile("text.txt");
    	writeToFile("chiffre.txt", Rsa.encrypt(message, publicKey));
    }
    
    public static void task3() {
    	PrivateKey privateKey = new PrivateKey("sk.txt");
    	String encryptedMessage = readFromFile("chiffre.txt");
    	writeToFile("text-d.txt", Rsa.decrypt(encryptedMessage, privateKey));
    }
    
    public static void task4() {
    	PrivateKey privateKey = new PrivateKey("sk.txt");
    	String encryptedMessage = readFromFile("chiffre.txt");
    	System.out.println(Rsa.decrypt(encryptedMessage, privateKey));
    	// Output: "Das haben Sie gut gemacht!" - yay! :D
    }
    
    public static String readFromFile(String path) {
    	try {
			return new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public static void writeToFile(String path, String text) {
    	try {
			Files.write(Paths.get(path), text.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
