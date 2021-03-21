import Admin.Admin;

import java.io.File;

public enum CommandsEnumWrite {

    CLEAR(new Clear()),
    FEAL(new FileEditAllLines()),
    FRAL(new FileReplaceAllLines()),
    HELP(new WriteHelp());

    private final CommandFileEdit c;

    CommandsEnumWrite(CommandFileEdit command) {
        this.c = command;
    }

    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        this.c.execute(args, command, file, app, admin);
    }
}
