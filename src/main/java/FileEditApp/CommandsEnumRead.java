package FileEditApp;

public enum CommandsEnumRead {

    HELP(new ReadHelp());

    private final Command c;

    CommandsEnumRead(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command, String path) {
        this.c.execute(args, command, path);
    }
}
