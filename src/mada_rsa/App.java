package mada_rsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        KeyPair kp = new KeyPair();
        try {
			Files.write(Paths.get("sk.txt"), kp.getPrivateKey().toString().getBytes());
			Files.write(Paths.get("pk.txt"), kp.getPublicKey().toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
