import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a path to begin");
        String path = getScanner().next();
        String answer = path;
        //Desktop.getDesktop().open((new File(path))); ajouter une commande
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("You can now enter commands");
                System.out.print("(" + path + ") -> ");
                while (!answer.equals("stop")) {
                    answer = getScanner().nextLine();
                }
            }else {
                System.out.println("This is not a directory");
            }
        }else {
            System.out.println("You can only enter an existing directory");
        }
    }

    public static Scanner getScanner() { // pour vider la mémoire du scanner à chaque fois et éviter les erreurs
        return new Scanner(System.in);
    }
}
