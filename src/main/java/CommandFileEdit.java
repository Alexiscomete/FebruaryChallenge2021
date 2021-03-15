import Admin.Admin;

import java.io.File;

public abstract class CommandFileEdit {
    public abstract void execute(String[] args, String command, File file, FileEditApp app, Admin admin);
}
