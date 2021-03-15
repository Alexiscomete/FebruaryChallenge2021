import Admin.Admin;

public enum CommandsEnumWrite {

    HELP(new WriteHelp());

    private final CommandFileEdit c;

    CommandsEnumWrite(CommandFileEdit command) {
        this.c = command;
    }

    public void execute(String[] args, String command, String path, FileEditApp app, Admin admin) {
        this.c.execute(args, command, path, app, admin);
    }
}
