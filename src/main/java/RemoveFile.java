import Admin.Admin;

import java.io.File;

public class RemoveFile implements CommandFileEdit{
    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        if (admin.isAdmin("remove a file")) {
            System.out.println(file.delete());
            app.answer = "stop";
        }
    }
}
