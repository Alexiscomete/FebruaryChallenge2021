import Admin.Admin;

import java.io.File;
import java.io.IOException;

public class CreateNewFile implements Command{
    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        System.out.println("Enter a name :");
        String name = path + app.sc.getScanner().nextLine();
        try {
            System.out.println(new File(name).createNewFile());
        } catch (IOException e) {
            System.out.println("Don't try to crash me!");
        }
    }
}
