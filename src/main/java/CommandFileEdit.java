import Admin.Admin;

import java.io.File;

@FunctionalInterface
public interface CommandFileEdit {
    void execute(String[] args, String command, File file, FileEditApp app, Admin admin);
}
