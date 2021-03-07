import java.util.Scanner;

public class FileEdit extends Command{
    @Override
    public void execute(String[] args, String command) {

    }

    public void mainLoop() {
        String answer = "";
        String file = "";
        System.out.println("Welcome to the text editor");
        while (!answer.equals("stop")) {
            System.out.print("|]" + file + "[| -> ");
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
