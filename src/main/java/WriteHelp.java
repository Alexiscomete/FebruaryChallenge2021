import Admin.Admin;

public class WriteHelp extends CommandFileEdit {

    @Override
    public void execute(String[] args, String command, String path, FileEditApp app, Admin admin) {
        System.out.println("Use >> to write a lign");

    }
}
