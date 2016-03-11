package mada_rsa;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;

public class PrivateKey {
	private BigInteger n;
	private BigInteger d;
	
	public PrivateKey(BigInteger n, BigInteger d) {
		this.n = n;
		this.d = d;
	}
	
	public PrivateKey(File file) {
	    String s = App.getFileContent(file);
	    //ev klammern weg? hat es?
	    n = new BigInteger (s.split(",")[0]);
	    d = new BigInteger (s.split(",")[1]);
	}

	public BigInteger getN() {
		return n;
	}
	public BigInteger getD() {
		return d;
	}
}
