import java.io.File;
import java.util.Scanner;

public class Main {
    public static String path = "C:";
    public static String answer = "C:";

    public static void main(String[] args) {
        System.out.println("Enter a path to begin");
        path = getScanner().nextLine();
        answer = path;

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                mainLoop();
            }else {
                System.out.println("This is not a directory, open C:");
                path = "C:";
                mainLoop();
            }
        }else {
            System.out.println("You can only enter an existing directory, open C:");
            path = "C:";
            mainLoop();
        }
    }

    public static void mainLoop() {
        System.out.println("You can now enter commands");
        while (!answer.equals("stop")) {
            System.out.print("(" + path + ") -> ");
            answer = getScanner().nextLine();
            String[] commandArgs = answer.split(" ");
            try {
                CommandsEnum c = CommandsEnum.valueOf(commandArgs[0].toUpperCase());
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
