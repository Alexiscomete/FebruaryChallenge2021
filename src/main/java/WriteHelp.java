import Admin.Admin;

import java.io.File;

public class WriteHelp extends CommandFileEdit {

    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        System.out.println("Use >> to write a lign, >>clear to clear, >>feal to edit all content");
    }
}
