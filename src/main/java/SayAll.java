import Admin.Admin;

public class SayAll implements Command {

    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        System.out.println("Start with - all of yours lines");
        String answer = "-";
        while (answer.startsWith("-")) {
            answer = app.sc.getScanner().nextLine();
            System.out.println(answer.substring(1));
        }
    }
}
