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
	private BigInteger e = new BigInteger("11"); // use 11 as default
	
	/**
	 * Generates a random RSA KeyPair, consisting of a PrivateKey and a PublicKey
	 * @param bitLength - bit length of the random generated prime numbers
	 */
	public KeyPair(int bitLength) {
		Random rnd = new Random();
		p = BigInteger.probablePrime(bitLength, rnd); // get first random prime
		// potential problem: what if there is no such number? (eg if you chose only 4 bit numbers and e=3) --> increase e?
		do { 
			q = BigInteger.probablePrime(bitLength, rnd); // get second random prime
			phi = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1"))); // phi = phi(n) = (p-1)(q-1)
		}
		while (!euclid(phi, e, false).equals(new BigInteger("1")) // make sure it's "teilerfremd" from e (gcd must be 1)
			|| q.equals(p)); // and also make sure it's not the same as p
		n = p.multiply(q); // product of the two chosen primes	
		d = euclid(phi, e, true); // find d that matches: e * d mod phi(n) = 1 mod phi(n)
		privateKey = new PrivateKey(n, d);
		publicKey = new PublicKey(n, e);
	}
	
	public KeyPair() {
		this(1024); // use 1024 as default bitLength
	}
	
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
	
	/**
	 * Extended Euclidian Algorithm, "copied" pseudo code from slide 1.26.
	 * @param a - first number (phi(n))
	 * @param b - second number (e)
	 * @param returnBezoutCoefficient - if set to true, returns the bezout coefficient, otherwise the greatest common divisor
	 * @return Depending on last param: greatest common divisor OR bezout coefficient, the secret number d to use for the RSA private key
	 */
	private BigInteger euclid(BigInteger a, BigInteger b, boolean returnBezoutCoefficient) {
		if (a.compareTo(b) < 0) { BigInteger tmp = a; a = b; b = tmp; } // make sure a is greater than b
		BigInteger x0 = new BigInteger("1"); // Bezout Coefficient
		BigInteger y0 = new BigInteger("0"); // Bezout Coefficient
		BigInteger x1 = new BigInteger("0");
		BigInteger y1 = new BigInteger("1");
		BigInteger q = a.divide(b); // quotient
		BigInteger r = a.mod(b); // remainder
		BigInteger prevx0, prevy0; // needed to store previous value, used to calculate next values
		while (true) { // using a while (true) because it has to end mid-loop as soon as b equals 0
			prevx0 = x0;
			prevy0 = y0;
			x0 = x1;
			y0 = y1;
			a = b; //greatest common divisor
			b = r;
			if (b.equals(new BigInteger("0"))) break; // algorithm is finished when b equals 0. stop there to prevent division by zero.
			x1 = prevx0.subtract(q.multiply(x1));
			y1 = prevy0.subtract(q.multiply(y1));
			q = a.divide(b);
			r = a.mod(b);
		}
		if (returnBezoutCoefficient) return y0; // bezout coefficient
		return a; // gcd
	}
}
