import Admin.Admin;

public abstract class Command {
    public abstract void execute(String[] args, String command, String path, MainApp app, Admin admin);
}
