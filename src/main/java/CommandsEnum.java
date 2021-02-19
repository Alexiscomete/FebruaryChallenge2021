public enum CommandsEnum {

    HELP(new Help()),
    OD(new OpenDesktop()),
    LIST(new ListCommand()),
    TREE(new TreeCommand()),
    CD(new ChangeDirectory());

    private final Command c;

    CommandsEnum(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command) {
        this.c.execute(args, command);
    }
}