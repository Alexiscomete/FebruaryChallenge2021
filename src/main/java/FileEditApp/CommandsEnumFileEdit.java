package FileEditApp;

public enum CommandsEnumFileEdit {

    ;

    private final Command c;

    CommandsEnumFileEdit(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command) {
        this.c.execute(args, command);
    }
}
