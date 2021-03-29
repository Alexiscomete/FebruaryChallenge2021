import Admin.Admin;

public class Say implements Command{
    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        System.out.println(app.sc.getScanner().nextLine());
    }
}
