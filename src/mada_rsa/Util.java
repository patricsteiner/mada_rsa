package mada_rsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

	/**
	 * Reads a file and returns the whole content as a single String
	 * @param path - Path to the file
	 * @return file content as a String
	 */
    public static String readFromFile(String path) {
    	try {
			return new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
	/**
	 * Writes a String to the specified file
	 * @param path - Path to the file
	 * @param text - Text to write in the file
	 */
    public static void writeToFile(String path, String text) {
    	try {
			Files.write(Paths.get(path), text.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
