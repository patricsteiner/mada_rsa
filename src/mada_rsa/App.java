package mada_rsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author Patric Steiner <patric.steiner@students.fhnw.ch>
 * 
 *
 */
public class App {
    public static void main(String[] args) {
        //KeyPair kp = new KeyPair();

        
        //3: read chiffre.txt and decrypt with sk.txt into text-d.txt
    	// Output: "Das haben Sie gut gemacht!" - yay! :D
        String decryptedMessage = Rsa.decrypt(readFromFile("chiffre.txt"), new PrivateKey("sk.txt"));
        System.out.println(decryptedMessage);
        writeToFile("text-d.txt", decryptedMessage);      
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
