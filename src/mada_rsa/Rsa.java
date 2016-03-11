package mada_rsa;

import java.math.BigInteger;

public class Rsa {
	public static String encrypt(String message, PublicKey publicKey) {
		String encryptedMessage = "";
		for (int i = 0; i < message.length(); i++) {
			encryptedMessage += squareAndMultiply(
					new BigInteger(Integer.toString(message.charAt(i))), //make char ascii value to BigInteger
					publicKey.getN(), 
					publicKey.getE())
					+ ",";
		}
		encryptedMessage = encryptedMessage.substring(0, encryptedMessage.length() - 1); //cut last comma
		return encryptedMessage;
	}
	
	public static String decrypt(String message, PrivateKey privateKey) {
		String decryptedMessage = "";
		for (String s : message.split(",")) {
			decryptedMessage += Character.toString((char)
					squareAndMultiply(new BigInteger(s), privateKey.getN(), privateKey.getD()
					).intValue());
		}
		return decryptedMessage;
	}
	
	private static BigInteger squareAndMultiply(BigInteger x, BigInteger m, BigInteger e) {
		//fast exponentiation algorithm, "copied" pseudo code from slide 1.32
		int i = e.toString(2).length() - 1; //length of e in binary
		BigInteger h = new BigInteger("1");
		BigInteger k = x;
		while (i >= 0) {
			if (e.toString(2).charAt(i) == '1') h = h.multiply(k).mod(m);
			k = k.multiply(k).mod(m);
			i--;
		}
		return h;
	}
}
