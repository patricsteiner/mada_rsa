package mada_rsa;

import java.math.BigInteger;
import java.util.Random;

public class KeyPair {
	private PublicKey publicKey;
	private PrivateKey privateKey;
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger d;
	private BigInteger e = new BigInteger("3");
	
	public KeyPair() {
		Random rnd = new Random();
		p = BigInteger.probablePrime(1024, rnd); //get first random prime
		do {q = BigInteger.probablePrime(1024, rnd);} while (q.equals(p)); //get second random prime, make sure it's different from p
		n = p.multiply(q);
		phi = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
		privateKey = new PrivateKey(n,d);
		publicKey = new PublicKey(n, e);
	}
	
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
	
	private BigInteger gcd(BigInteger a, BigInteger b) {
		// extended euclidian algorithm, "copied" pseudo code from slides
		if (a.compareTo(b) < 0) {BigInteger tmp=a; a=b;b=tmp;} //make sure a is greater than b
		BigInteger x0 = new BigInteger("1");
		BigInteger y0 = new BigInteger("0");
		BigInteger x1 = new BigInteger("0");
		BigInteger y1 = new BigInteger("1");
		BigInteger q,r;
		while (!b.equals(new BigInteger("0"))) {
			q = a.divide(b);
			r = a.mod(b);
			a = b;
			b = r;
			x0 = x1;
			x0 = y1;
			x1 = x0.subtract(q.multiply(x1));
			y1 = y0.subtract(q.multiply(y1));
		}
		return a;
	}
}
