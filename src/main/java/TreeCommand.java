import java.io.File;

public class TreeCommand extends Command{
    @Override
    public void execute(String[] args, String command) {
        if (args.length > 1) {
            getDirectorySize(Main.path, 0);
        }else {
            sendTree(Main.path, 0);
        }

    }

    private static void sendTree(String path, int n) {
        File f = new File(path);
        String[] list = f.list();
        StringBuilder tab = new StringBuilder();
        tab.append("\t".repeat(Math.max(0, n)));
        if (list != null) {
            for (String str : list) {
                File file = new File(path + "\\" + str);
                if (file.isDirectory()) {
                    System.out.println(tab + "+ " + str);
                    sendTree(path + "\\" + str, n + 1);
                }else {
                    System.out.println(tab + "- " + str);
                }
            }
        }
    }

    private static long getDirectorySize(String path, int n) {
        File f = new File(path);
        StringBuilder tab = new StringBuilder();
        tab.append("\t".repeat(Math.max(0, n)));
        long answer = 0;
        String[] list = f.list();
        if (list != null) {
            for (String str : list) {
                File file = new File(path + "\\" + str);
                if (file.isDirectory()) {
                    long temp = getDirectorySize(path + "\\" + str, n + 1);
                    System.out.println(tab + "+ " + str + " + " + temp + " byte(s)");
                    answer += temp;
                } else {
                    long temp = file.length();
                    System.out.println(tab + "- " + str + " - " + temp + " byte(s)");
                    answer += temp;
                }
            }
        }
        return answer;
    }
}
