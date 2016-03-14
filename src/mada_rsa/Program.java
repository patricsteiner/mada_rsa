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
	static final String PATH_PRIVATE_KEY =			"sk.txt";
	static final String PATH_PUBLIC_KEY =			"pk.txt";
	static final String PATH_MESSAGE =				"text.txt";
	static final String PATH_DECRYPTED_MESSAGE =	"text-d.txt";
	static final String PATH_ENCRYPTED_MESSAGE =	"chiffre.txt";

	/**
	 * Each task = "Aufgabe" according to "bonus-RSA.pdf".
	 * Simply un-comment the task you would like to see (only one at a time, otherwise stuff can get mixed up).
	 * Or just have a look at the available functions in the task and try it yourself.
	 * It should be pretty self-explanatory.
	 * By default all files are read from and written to the current directory.
	 * Change the paths above if you want something else.
	 */
    public static void main(String[] args) {
    	task1();
//    	task2();
//    	task3();
//    	task4();
    }
    
    /**
     * Task #1: Generate random public and private key, save to sk.txt and pk.txt respectively.
     */
    public static void task1() {
    	 KeyPair keyPair = new KeyPair();
         Util.writeToFile(PATH_PRIVATE_KEY, keyPair.getPrivateKey().toString());
         Util.writeToFile(PATH_PUBLIC_KEY, keyPair.getPublicKey().toString());
         System.out.println("Generated new Keypair, saved private key to " + PATH_PRIVATE_KEY + " and public key to " + PATH_PUBLIC_KEY);
         System.out.println("Private key: " + keyPair.getPrivateKey());
         System.out.println("Public key: " + keyPair.getPublicKey());
    }
    
    /**
     * Task #2: Read text from file text.txt and encrypt it with the public key in pk.txt.
     * Write output to chiffre.txt.
     */
    public static void task2() {
    	PublicKey publicKey = new PublicKey(PATH_PUBLIC_KEY);
    	String message = Util.readFromFile(PATH_MESSAGE);
    	String encryptedMessage = RSA.encrypt(message, publicKey);
    	Util.writeToFile(PATH_ENCRYPTED_MESSAGE, encryptedMessage);
    	System.out.println("Message from " + PATH_MESSAGE + " : " + message);
    	System.out.println("Encrypted message saved to " + PATH_ENCRYPTED_MESSAGE + ": " + encryptedMessage);
    }
    
    /**
     * Task #3: Private key in sk.txt to decrypt the text in chiffre.txt.
     * Write output to text-d.txt.
     */
    public static void task3() {
        System.out.println("Be patient, decrypting may take a few seconds...");
    	PrivateKey privateKey = new PrivateKey(PATH_PRIVATE_KEY);
    	String encryptedMessage = Util.readFromFile(PATH_ENCRYPTED_MESSAGE);
    	String decryptedMessage = RSA.decrypt(encryptedMessage, privateKey);
    	Util.writeToFile("text-d.txt", decryptedMessage);
    	System.out.println("Encrypted message from " + PATH_ENCRYPTED_MESSAGE + ": " + encryptedMessage);
    	System.out.println("Decrypted message saved to " + PATH_DECRYPTED_MESSAGE + ": " + decryptedMessage);
    }
    
    /**
     * Task #4: Decrypt text in chiffre.txt with private key in sk.txt.
     * Output decrypted message to stdout.
     */
    public static void task4() {
        System.out.println("Be patient, decrypting may take a few seconds...");
    	PrivateKey privateKey = new PrivateKey(PATH_PRIVATE_KEY);
    	String encryptedMessage = Util.readFromFile(PATH_ENCRYPTED_MESSAGE);
    	System.out.println(RSA.decrypt(encryptedMessage, privateKey));
    	// Output: "Das haben Sie gut gemacht!" - yay! :D
    }
}
