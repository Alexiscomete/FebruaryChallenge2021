public enum CommandsEnum {

    HELP(new Help()),
    OD(new OpenDesktop()),
    LIST(new ListCommand()),
    TREE(new TreeCommand()),
    CD(new ChangeDirectory()),
    RC(new ReadC()),
    FE(new FileEdit());

    private final Command c;

    CommandsEnum(Command command) {
        this.c = command;
    }

    public void execute(String[] args, String command, String path, MainApp app) {
        this.c.execute(args, command, path, app);
    }
}