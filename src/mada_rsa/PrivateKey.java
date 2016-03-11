package mada_rsa;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrivateKey {
	private BigInteger n;
	private BigInteger d;
	
	public PrivateKey(BigInteger n, BigInteger d) {
		this.n = n;
		this.d = d;
	}
	
	public PrivateKey(Path path) {
	    String s = null;
		try {
			s = Files.readAllLines(path).get(0);
			s = s.substring(1, s.length()-2); //remove brackets
		    n = new BigInteger (s.split(",")[0]);
		    d = new BigInteger (s.split(",")[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BigInteger getN() {
		return n;
	}
	public BigInteger getD() {
		return d;
	}
	
	@Override
	public String toString() {
		return "(" + n + "," + d + ")";
	}
}
