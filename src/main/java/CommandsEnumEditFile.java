import Admin.Admin;

import java.io.File;

public enum CommandsEnumEditFile {

    CLEAR(new Clear()),
    FEAL(new FileEditAllLines()),
    FRAL(new FileReplaceAllLines()),
    HELP(new HelpEdit()),
    RF(new RemoveFile());

    private final CommandFileEdit c;

    CommandsEnumEditFile(CommandFileEdit c) {
        this.c = c;
    }

    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        this.c.execute(args, command, file, app, admin);
    }
}
