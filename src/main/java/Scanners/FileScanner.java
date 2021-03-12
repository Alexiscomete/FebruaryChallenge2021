package Scanners;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner implements GetScanner {
    Scanner scanner;

    public FileScanner(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found : manuel mode");
            scanner = new Scanner(System.in);
        }
    }


    @Override
    public Scanner getScanner() {
        return scanner;
    }
}
