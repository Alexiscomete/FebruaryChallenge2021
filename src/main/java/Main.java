import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a path to begin");
        String path = getScanner().next();
    }

    public static Scanner getScanner() { // pour vider la mémoire du scanner à chaque fois et éviter les erreurs
        return new Scanner(System.in);
    }
}
