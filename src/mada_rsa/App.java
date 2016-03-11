package mada_rsa;

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
    	task4();
    }
    
    // Task #1: Generate random public and private key, save to sk.txt and pk.txt
    public static void task1() {
    	 KeyPair keyPair = new KeyPair();
         Util.writeToFile("sk.txt", keyPair.getPrivateKey().toString());
         Util.writeToFile("pk.txt", keyPair.getPublicKey().toString());
    }
    
    public static void task2() {
    	PublicKey publicKey = new PublicKey("pk.txt");
    	String message = Util.readFromFile("text.txt");
    	Util.writeToFile("chiffre.txt", Rsa.encrypt(message, publicKey));
    }
    
    public static void task3() {
    	PrivateKey privateKey = new PrivateKey("sk.txt");
    	String encryptedMessage = Util.readFromFile("chiffre.txt");
    	Util.writeToFile("text-d.txt", Rsa.decrypt(encryptedMessage, privateKey));
    }
    
    public static void task4() {
    	PrivateKey privateKey = new PrivateKey("sk.txt");
    	String encryptedMessage = Util.readFromFile("chiffre.txt");
    	System.out.println(Rsa.decrypt(encryptedMessage, privateKey));
    	// Output: "Das haben Sie gut gemacht!" - yay! :D
    }
}
