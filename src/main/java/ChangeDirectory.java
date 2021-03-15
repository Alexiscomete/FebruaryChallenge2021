import Admin.Admin;

import java.io.File;
import java.nio.file.Paths;

public class ChangeDirectory extends Command{
    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        String newPath = command.substring(3);
        if (!newPath.startsWith(".")) {
            File file = new File(newPath);
            if (file.exists()) {
                if (file.isDirectory()) {
                    app.path = newPath;
                    System.out.println("The path has been changed");
                }else {
                    System.out.println("This is not a directory");
                }
            }else {
                System.out.println("You can only enter an existing directory");

            }
        }else {
            File file = new File(Paths.get(path + "/" + newPath).normalize().toString());
            if (file.exists()) {
                if (file.isDirectory()) {
                    app.path = file.getAbsolutePath();
                    System.out.println("The path has been changed");
                }else {
                    System.out.println("This is not a directory");
                }
            }else {
                System.out.println("You can only enter an existing directory");

            }
        }
    }
}
