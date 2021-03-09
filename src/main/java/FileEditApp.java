import java.io.File;
import java.util.Scanner;
import FileEditApp.CommandsEnumFileEdit;

public class FileEditApp implements App{
    String fileName;
    File file;

    public FileEditApp(String fileName, File file) {

    }

    @Override
    public void mainLoop() {
        String answer = "";
        System.out.println("Welcome to the text editor");
        while (!answer.equals("stop")) {
            System.out.print("|]" + fileName + "[| -> ");
            answer = getScanner().nextLine();
            String[] commandArgs = answer.split(" ");
            try {
                CommandsEnumFileEdit c = CommandsEnumFileEdit.valueOf(commandArgs[0].toUpperCase());
                c.execute(commandArgs, answer);
            }catch (IllegalArgumentException e) {
                if (!answer.equals("stop")) System.out.println("This is not a command, use help");
            }
        }
    }

    public static Scanner getScanner() { // pour vider la mémoire du scanner à chaque fois et éviter les erreurs
        return new Scanner(System.in);
    }
}
