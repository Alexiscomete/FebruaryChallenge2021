import Admin.Admin;

public enum CommandsEnumRead {

    HELP(new ReadHelp());

    private final CommandFileEdit c;

    CommandsEnumRead(CommandFileEdit command) {
        this.c = command;
    }

    public void execute(String[] args, String command, String path, FileEditApp app, Admin admin) {
        this.c.execute(args, command, path, app, admin);
    }}
