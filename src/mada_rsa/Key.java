package mada_rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Key {

	private BigInteger part1;
	private BigInteger part2;
	
	public Key(BigInteger part1, BigInteger part2) {
		this.part1 = part1;
		this.part2 = part2;
	}
	
	public Key(String path) {
	    String s = null;
		try {
			s = Files.readAllLines(Paths.get(path)).get(0);
			s = s.substring(1, s.length() - 1); //remove brackets
		    part1 = new BigInteger(s.split(",")[0]);
		    part2 = new BigInteger(s.split(",")[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BigInteger getPart1() {
		return part1;
	}
	public BigInteger getPart2() {
		return part2;
	}
	
	@Override
	public String toString() {
		return "(" + part1 + "," + part2 + ")";
	}
}
