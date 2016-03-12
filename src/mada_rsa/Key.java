package mada_rsa;

import java.math.BigInteger;

public abstract class Key {

	private BigInteger part1;
	private BigInteger part2;
	
	/**
	 * RSA Key consisting of two separate parts
	 * @param part1
	 * @param part2
	 */
	public Key(BigInteger part1, BigInteger part2) {
		this.part1 = part1;
		this.part2 = part2;
	}
	
	/**
	 * Create Key by a file containing the two parts. File must be formatted correctly:
	 * (part1,part2)
	 * @param path - Path to the file
	 */
	public Key(String path) {
	    String s = null;
	    s = Util.readFromFile(path);
	    s = s.substring(1, s.length() - 1); //remove brackets
	    part1 = new BigInteger(s.split(",")[0]);
	    part2 = new BigInteger(s.split(",")[1]);
	}

	public BigInteger getPart1() {
		return part1;
	}
	public BigInteger getPart2() {
		return part2;
	}
	
	@Override
	/**
	 * String representation of this RSA key. Can be used to store in a file.
	 */
	public String toString() {
		return "(" + part1 + "," + part2 + ")";
	}
}
