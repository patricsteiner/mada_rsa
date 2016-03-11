package mada_rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrivateKey {
	private BigInteger n;
	private BigInteger d;
	
	public PrivateKey(BigInteger n, BigInteger d) {
		this.n = n;
		this.d = d;
	}
	
	public PrivateKey(String path) {
	    String s = null;
		try {
			s = Files.readAllLines(Paths.get(path)).get(0);
			s = s.substring(1, s.length() - 1); //remove brackets
		    n = new BigInteger(s.split(",")[0]);
		    d = new BigInteger(s.split(",")[1]);
		} catch (IOException e) {
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
