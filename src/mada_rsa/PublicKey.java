package mada_rsa;

import java.math.BigInteger;

public class PublicKey extends Key {
	
	public BigInteger n = getPart1();
	public BigInteger e = getPart2();
	
	public PublicKey(BigInteger part1, BigInteger part2) {
		super(part1, part2);
	}
	
	public PublicKey(String path) {
		super(path);
	}
}
