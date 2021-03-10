package FileEditApp;

public enum CommandsEnumWrite {

    HELP(new WriteHelp());

    private final Command c;

    CommandsEnumWrite(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command) {
        this.c.execute(args, command);
    }
}
