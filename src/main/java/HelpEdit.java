import Admin.Admin;

import java.io.File;

public class HelpEdit implements CommandFileEdit {

    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        System.out.println("Use >> to write a line, << to print the file (in terminal), clear to clear, feal to edit all content, fral : replace line per line content of the file, rf : redstone flux ... no ... remove a file");
    }
}
