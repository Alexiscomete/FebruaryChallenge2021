import Admin.Admin;

@FunctionalInterface
public interface Command {
    void execute(String[] args, String command, String path, MainApp app, Admin admin);
}
