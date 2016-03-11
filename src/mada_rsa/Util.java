package mada_rsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public static String readFromFile(String path) {
    	try {
			return new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public static void writeToFile(String path, String text) {
    	try {
			Files.write(Paths.get(path), text.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
