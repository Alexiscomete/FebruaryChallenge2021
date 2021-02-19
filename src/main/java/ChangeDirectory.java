import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChangeDirectory extends Command{
    @Override
    public void execute(String[] args, String command) {
        String newPath = command.substring(3);
        if (!newPath.startsWith(".")) {
            File file = new File(newPath);
            if (file.exists()) {
                if (file.isDirectory()) {
                    Main.path = newPath;
                    System.out.println("The path has been changed");
                }else {
                    System.out.println("This is not a directory");
                }
            }else {
                System.out.println("You can only enter an existing directory");

            }
        }else {
            File file = new File(Paths.get(Main.path + "/" + newPath).normalize().toString());
            if (file.exists()) {
                if (file.isDirectory()) {
                    Main.path = file.getAbsolutePath();
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
