public enum CommandsEnum {

    HELP(new Help());

    private final Command c;

    CommandsEnum(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command) {
        this.c.execute(args, command);
    }
}
