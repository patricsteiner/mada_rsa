package mada_rsa;

import java.math.BigInteger;

public class PrivateKey extends Key {

	public BigInteger n = getPart1();
	public BigInteger d = getPart2();
	
	public PrivateKey(BigInteger part1, BigInteger part2) {
		super(part1, part2);
	}

	public PrivateKey(String path) {
		super(path);
	}
}
