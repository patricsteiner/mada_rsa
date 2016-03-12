package mada_rsa;

import java.math.BigInteger;

public class RSA {
	
	/**
	 * Encrypt message with RSA public key. 
	 * Every single character of the message will be encrypted separately
	 * @param message - the message to encrypt
	 * @param publicKey - key used for encryption
	 * @return comma separated String, each value representing a single ascii character
	 */
	public static String encrypt(String message, PublicKey publicKey) {
		String encryptedMessage = "";
		for (int i = 0; i < message.length(); i++) { // encrypt every character seperately
			encryptedMessage += squareAndMultiply(
					new BigInteger(Integer.toString(message.charAt(i))), // make char ascii value to BigInteger
					publicKey.n, 
					publicKey.e)
					+ ",";
		}
		encryptedMessage = encryptedMessage.substring(0, encryptedMessage.length() - 1); // remove last comma
		return encryptedMessage;
	}
	
	/**
	 * Decrypt message with RSA private key.
	 * @param message - must be a String of comma separated encrypted ascii characters
	 * @param privateKey - key used for decryption
	 * @return decrypted message
	 */
	public static String decrypt(String message, PrivateKey privateKey) {
		String decryptedMessage = "";
		for (String s : message.split(",")) { // decrypt every substring (number between commas) to an ascii caharcter
			decryptedMessage += Character.toString((char)
					squareAndMultiply(new BigInteger(s), privateKey.n, privateKey.d
					).intValue());
		}
		return decryptedMessage;
	}
	
	/**
	 * fast exponentiation algorithm, "copied" pseudo code from slide 1.32
	 * this is an efficient way to calculate x^e mod m
	 * @param x - base
	 * @param m - modulus
	 * @param e - exponent
	 * @return x^e mod m
	 */
	private static BigInteger squareAndMultiply(BigInteger x, BigInteger m, BigInteger e) {
		int i = e.toString(2).length() - 1; // length of e in binary
		BigInteger h = new BigInteger("1");
		BigInteger k = x; // used because it's the same in the slides (convention?)
		while (i >= 0) {
			if (e.toString(2).charAt(i) == '1') h = h.multiply(k).mod(m);
			k = k.multiply(k).mod(m);
			i--;
		}
		return h; //x^e mod m
	}
}
