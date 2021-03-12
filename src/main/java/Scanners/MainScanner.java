package Scanners;

import java.util.Scanner;

public class MainScanner implements GetScanner {
    @Override
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
