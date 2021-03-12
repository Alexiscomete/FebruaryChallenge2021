import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenDesktop extends Command{

    @Override
    public void execute(String[] args, String command) {
        try {
            Desktop.getDesktop().open((new File(MainApp.path)));
            System.out.println("The directory is open on your desktop");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("You can enter a command");
        }
    }
}
