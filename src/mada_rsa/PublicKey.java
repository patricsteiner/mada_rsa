package mada_rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PublicKey {
	private BigInteger n;
	private BigInteger e;
	
	public PublicKey(BigInteger n, BigInteger e) {
		this.n = n;
		this.e = e;
	}
	
	public PublicKey(String path) {
	    String s = null;
		try {
			s = Files.readAllLines(Paths.get(path)).get(0);
			s = s.substring(1, s.length() - 1); //remove brackets
		    n = new BigInteger(s.split(",")[0]);
		    e = new BigInteger(s.split(",")[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BigInteger getN() {
		return n;
	}
	public BigInteger getE() {
		return e;
	}
	
	@Override
	public String toString() {
		return "(" + n + "," + e + ")";
	}
}
