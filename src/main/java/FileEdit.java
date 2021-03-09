//import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class FileEdit extends Command{

    @Override
    public void execute(String[] args, String command) {
        System.out.println(/*Color.ORANGE + */"Enter a file to start application");
        String fileName = getScanner().nextLine();
        File file = new File(fileName);
        if (file.exists() && !file.isDirectory()) {
            new FileEditApp(fileName, file);
        }
    }

    public static Scanner getScanner() { // pour vider la mémoire du scanner à chaque fois et éviter les erreurs
        return new Scanner(System.in);
    }
}
