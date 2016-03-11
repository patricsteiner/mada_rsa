package mada_rsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new KeyPair().createFiles();
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
    
    public static void saveToFile(String text, File file) {
        try {
            new FileWriter(file).write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
