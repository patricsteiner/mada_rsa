package mada_rsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

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
    
    public static String getFileContent(File file){
        String res = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                res += scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
