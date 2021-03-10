package FileEditApp;

public enum CommandsEnumRead {

    HELP(new ReadHelp());

    private final Command c;

    CommandsEnumRead(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command) {
        this.c.execute(args, command);
    }
}
