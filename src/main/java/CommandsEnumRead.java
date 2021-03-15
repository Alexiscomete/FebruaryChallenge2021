import Admin.Admin;

import java.io.File;

public enum CommandsEnumRead {

    HELP(new ReadHelp());

    private final CommandFileEdit c;

    CommandsEnumRead(CommandFileEdit command) {
        this.c = command;
    }

    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        this.c.execute(args, command, file, app, admin);
    }}
