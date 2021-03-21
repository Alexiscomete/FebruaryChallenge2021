import Admin.Admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileReplaceAllLines extends CommandFileEdit {
    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        if (admin.isAdmin("replace all lines in a file")) {
            StringBuilder text = new StringBuilder();
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    System.out.print(sc.nextLine() + " --> ");
                    text.append(app.sc.getScanner().nextLine());
                    text.append("\n");
                }
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(String.valueOf(text).getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
