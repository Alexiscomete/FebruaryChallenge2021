import Admin.Admin;
import Scanners.GetScanner;

import java.io.*;
import java.util.Scanner;

public class FileEditApp extends App{
    public String fileName;
    public File file;

    public FileEditApp(String fileName, File file, Admin admin, GetScanner sc) {
        this.fileName = fileName;
        this.file = file;
        this.admin = admin;
        this.sc = sc;
        mainLoop();
    }

    @Override
    public void mainLoop() {
        String answer = "";
        System.out.println("Welcome to the text editor");
        System.out.println("<< for read, >> for write, use help");
        while (!answer.equals("stop")) {
            System.out.print("|]" + fileName + "[| -> ");
            answer = sc.getScanner().nextLine();
            String[] commandArgs = answer.split(" ");
            try {
                CommandsEnumEditFile c = CommandsEnumEditFile.valueOf(commandArgs[0].toUpperCase());
                c.execute(commandArgs, answer, file, this, admin);
            }catch (IllegalArgumentException e) {
                if (!answer.equals("stop")) {
                    if (answer.startsWith(">>")) {
                        try {
                            answer = answer.substring(2);
                            answer = getAllLines(this.file) + answer;
                            FileOutputStream fos = new FileOutputStream(file);
                            fos.write(answer.getBytes());
                            fos.close();
                        } catch (IOException fileNotFoundException) {
                            System.out.println("IOException");
                        }
                    }else if (answer.startsWith("<<")) {
                        try {
                            Scanner sc = new Scanner(file);
                            if (answer.length() == 2) {
                                while (sc.hasNextLine()) {
                                    System.out.println(sc.nextLine());
                                }
                            }else{
                                String arg = commandArgs[0].toUpperCase().substring(2);
                                int n = Integer.parseInt(arg);
                                for (int i = 0; i < n; i++) sc.nextLine();
                                System.out.println(sc.nextLine());
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    } else {
                        System.out.println("<< to print the file, >> for write a line in the file, use help");
                    }
                }
            }
        }
    }

    public static String getAllLines(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        StringBuilder answer = new StringBuilder();
        while (sc.hasNextLine()) {
            answer.append(sc.nextLine());
            answer.append("\n");
        }
        return answer.toString();
    }
}
