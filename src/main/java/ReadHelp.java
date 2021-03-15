import Admin.Admin;

public class ReadHelp extends CommandFileEdit {

    @Override
    public void execute(String[] args, String command, String path, FileEditApp app, Admin admin) {
        System.out.println("Use << to read a lign");
    }
}
