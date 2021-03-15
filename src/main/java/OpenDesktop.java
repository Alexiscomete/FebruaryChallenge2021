import Admin.Admin;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenDesktop extends Command{

    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        try {
            Desktop.getDesktop().open((new File(path)));
            System.out.println("The directory is open on your desktop");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("You can enter a command");
        }
    }
}
