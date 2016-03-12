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
public class Program {
	
	/**
	 * Each task = "Aufgabe" according to "bonus-RSA.pdf".
	 * Simply un-comment the function you would like to see.
	 * Or just have a look at the available functions in the task and try it yourself.
	 * It should be pretty self-explanatory.
	 * By default all files are read from and written to the current directory.
	 * Change the path if you want something else.
	 */
    public static void main(String[] args) {
    	//task1();
    	//task2();
    	//task3();
    	task4();
    }
    
    /**
     * Task #1: Generate random public and private key, save to sk.txt and pk.txt respectively
     */
    public static void task1() {
    	 KeyPair keyPair = new KeyPair();
         Util.writeToFile("sk.txt", keyPair.getPrivateKey().toString());
         Util.writeToFile("pk.txt", keyPair.getPublicKey().toString());
    }
    
    /**
     * Read text from file text.txt and encrypt it with the public key in pk.txt.
     * write output to chiffre.txt.
     */
    public static void task2() {
    	PublicKey publicKey = new PublicKey("pk.txt");
    	String message = Util.readFromFile("text.txt");
    	Util.writeToFile("chiffre.txt", RSA.encrypt(message, publicKey));
    }
    
    /**
     * Use private key in sk.txt to decrypt the text in chiffre.txt.
     * Write output to text-d.txt.
     */
    public static void task3() {
    	PrivateKey privateKey = new PrivateKey("sk.txt");
    	String encryptedMessage = Util.readFromFile("chiffre.txt");
    	Util.writeToFile("text-d.txt", RSA.decrypt(encryptedMessage, privateKey));
    }
    
    /**
     * Decrypt text in chiffre.txt with private key in sk.txt.
     * Output decrypted message to stdout.
     */
    public static void task4() {
    	PrivateKey privateKey = new PrivateKey("sk.txt");
    	String encryptedMessage = Util.readFromFile("chiffre.txt");
    	System.out.println(RSA.decrypt(encryptedMessage, privateKey));
    	// Output: "Das haben Sie gut gemacht!" - yay! :D
    }
}
