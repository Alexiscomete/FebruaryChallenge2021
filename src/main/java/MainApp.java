import Admin.Admin;
import Scanners.GetScanner;

import java.io.File;

public class MainApp implements App {

    public String path;
    public String answer;
    public GetScanner sc;
    public Admin admin;

    public MainApp(GetScanner sc, Admin yes) {
        System.out.println("Enter a path to begin");
        this.sc = sc;
        path = sc.getScanner().nextLine();
        admin = yes;


        File file = new File(path);
        if (file.exists()) {
            if (!file.isDirectory()) {
                System.out.println("This is not a directory, open C:/");
                path = "C:/";
            }
        }else {
            System.out.println("You can only enter an existing directory, open C:/");
            path = "C:/";

        }
        answer = path;
        mainLoop();
    }

    @Override
    public void mainLoop() {
        System.out.println("You can now enter commands");
        while (!answer.equals("stop")) {
            System.out.print("(" + path + ") -> ");
            answer = sc.getScanner().nextLine();
            String[] commandArgs = answer.split(" ");
            try {
                CommandsEnum c = CommandsEnum.valueOf(commandArgs[0].toUpperCase());
                c.execute(commandArgs, answer, path, this);
            }catch (IllegalArgumentException e) {
                if (!answer.equals("stop")) System.out.println("This is not a command, use help");
            }
        }
    }
}
