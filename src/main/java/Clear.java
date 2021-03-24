import Admin.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Clear implements CommandFileEdit {
    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        if (admin.isAdmin("clear a file")) {
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(file);
                fos.write("".getBytes());
                fos.close();
            } catch (IOException e) {
                System.out.println("Erreur !");
            }
        }
    }
}
