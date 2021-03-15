//import java.awt.*;

import Admin.Admin;

import java.io.File;

public class FileEdit extends Command{

    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        System.out.println(/*Color.ORANGE + */"Enter a file to start application");
        String fileName = app.sc.getScanner().nextLine();
        File file = new File(path + "/" + fileName);
        if (file.exists() && !file.isDirectory()) {
            new FileEditApp(fileName, file, admin, app.sc);
        }else{
            System.out.println("This is not a valid name");
        }
    }
}
