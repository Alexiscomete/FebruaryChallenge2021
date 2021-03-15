import Admin.Admin;
import Scanners.GetScanner;

import java.io.*;
import java.util.Scanner;

public class FileEditApp implements App{
    public String fileName;
    public File file;
    public Admin admin;
    public GetScanner sc;

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
        System.out.println("<< for read commands, >> for write commands, >>help and <<help");
        while (!answer.equals("stop")) {
            System.out.print("|]" + fileName + "[| -> ");
            answer = sc.getScanner().nextLine();
            String[] commandArgs = answer.split(" ");
            try {
                if (answer.startsWith(">>")) {
                    CommandsEnumWrite c = CommandsEnumWrite.valueOf(commandArgs[0].toUpperCase().substring(2));
                    c.execute(commandArgs, answer, file, this, admin);
                }else if (answer.startsWith("<<")){
                    CommandsEnumRead c = CommandsEnumRead.valueOf(commandArgs[0].toUpperCase().substring(2));
                    c.execute(commandArgs, answer, file, this, admin);
                }else{
                    System.out.println("<< for read commands, >> for write commands, >>help and <<help");
                }

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
