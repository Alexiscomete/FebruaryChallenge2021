import Admin.Admin;
import Scanners.GetScanner;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Locale;

public class MainApp extends App {

    public String path;
    public String answer;


    public MainApp(GetScanner sc, Admin yes) {
        System.out.println("Enter a path to begin");
        this.sc = sc;
        path = sc.getScanner().nextLine();
        admin = yes;

        // Get user home directory (C:\\Users\\Username in Windows)
        String userHome = Paths.get(System.getProperty("user.home")).normalize().toString().replace("\\", "/");
        path = Paths.get(path.replaceFirst("~", userHome)).normalize().toString();

        File file = new File(path);
        if (file.exists()) {
            if (!file.isDirectory()) {
                System.out.println("This is not a directory, opening project directory, think to use the / or \\ (like C:/)");
                String p = Main.class.getResource("Main.class").getPath();
                String first = p.substring(0, p.lastIndexOf('!')) + "/../";
                try {
                    path = Paths.get(first).normalize().toString();
                } catch (InvalidPathException e) {
                    path = Paths.get((first).substring(1)).normalize().toString();
                }
            }
        }else {
            System.out.println("You can only enter an existing directory, open project directory, think to use the / or \\ (like C:/)");
            try {
                path = Paths.get(getClass().getResource("Main.class").getPath() + "/../").normalize().toString();
            }catch (InvalidPathException e) {
                path = Paths.get((getClass().getResource("Main.class").getPath() + "/../").substring(1)).normalize().toString();
            }
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
                c.execute(commandArgs, answer, path, this, admin);
            }catch (IllegalArgumentException e) {
                if (!answer.equals("stop")) System.out.println("This is not a command, use help");
            }
        }
    }
}
