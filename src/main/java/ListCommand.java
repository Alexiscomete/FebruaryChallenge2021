import Admin.Admin;

import java.io.File;

public class ListCommand implements Command {
    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        File file = new File(path);
        String[] list = file.list();
        if (list == null) {
            System.out.println("List == null");
            return;
        }
        if (args.length > 1) {
            if (args[1].equals("s")) {
                for (String str : list) {
                    File f = new File(path + "/" + str);
                    if (f.isDirectory()) {
                        System.out.println("+ " + str);
                    }else {
                        System.out.println("- " + str + " - " + f.length() + " byte(s)");
                    }
                }
            }else if (args[1].equals("sd")) {
                for (String str : list) {
                    File f = new File(path + "/" + str);
                    if (f.isDirectory()) {
                        System.out.println("+ " + str + " + " + getDirectorySize(file) + " byte(s)");
                    }else {
                        System.out.println("- " + str + " - " + f.length() + " byte(s)");
                    }
                }
            }else {
                System.out.println("Invalid arg 1");
            }
        }else {
            for (String str : list) {
                System.out.println("- " + str);
            }
        }
    }

    private static long getDirectorySize(File f) {
        long answer = 0;
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    answer += getDirectorySize(file);
                }else {
                    answer += file.length();
                }
            }
        }
        return answer;
    }
}
