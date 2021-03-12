import Admin.AdminList;
import Scanners.FileScanner;

import java.io.File;

public class ExecuteFile extends Command{
    @Override
    public void execute(String[] args, String command, String path, MainApp app) {
        System.out.println("Enter a file to start application");
        String fileName = app.sc.getScanner().nextLine();
        File file = new File(path + "/" + fileName);
        if (file.exists() && !file.isDirectory()) {
            new MainApp(new FileScanner(file), AdminList.NO.ad);
        }else{
            System.out.println("This is not a valid name");
        }
    }
}
