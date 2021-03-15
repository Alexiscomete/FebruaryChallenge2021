import Admin.Admin;

public abstract class CommandFileEdit {
    public abstract void execute(String[] args, String command, String path, FileEditApp app, Admin admin);
}
