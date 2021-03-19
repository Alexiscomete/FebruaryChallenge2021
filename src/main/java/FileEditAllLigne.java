import Admin.Admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEditAllLigne extends CommandFileEdit {
    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        String content;
        try {
             content = FileEditApp.getAllLines(file);
        } catch (FileNotFoundException e) {
            System.out.println("???");
            return;
        }
        JTextArea jtf = new JTextArea(content);
        Font f = new Font("monospace", Font.PLAIN, 14);
        jtf.setFont(f);
        String[] strings = content.split("\n");
        int maxSize = 0;
        for (String str : strings) {
            if (str.length() > maxSize) {
                maxSize = str.length();
            }
        }
        WindowF w = new WindowF("FileEdit", maxSize * 25, strings.length * 40) {
            @Override
            public void waitClosed() {
                int maxLine = jtf.getText().split("\n").length;
                while (wait) {
                    String text = jtf.getText();
                    String[] lines = text.split("\n");
                    int pos = jtf.getCaretPosition();
                    int lineI = getLine(text, pos);
                    String line = lines[lineI];
                    if (maxLine < lines.length) {
                        if (text.endsWith("{\n")) {
                            int n = 0;
                            char c = line.charAt(0);
                            StringBuilder pre = new StringBuilder();
                            while (c == ' ') {
                                n++;
                                pre.append(" ");
                                c = line.charAt(n);
                                if (n == line.length()-1) {
                                    c = 'a';
                                }
                            }
                            String test = pre + "      \n" + pre + "}";
                            jtf.insert(test, getEndLine(text, lineI));
                            jtf.setCaretPosition(getEndLine(text, lineI));
                        }else if (text.endsWith("\n")) {
                            int n = 0;
                            char c = line.charAt(0);
                            StringBuilder pre = new StringBuilder();
                            while (c == ' ') {
                                n++;
                                pre.append(" ");
                                c = line.charAt(n);
                                if (n == line.length()-1) {
                                    c = 'a';
                                }
                            }
                            jtf.append(String.valueOf(pre));
                        }
                    }else{
                        maxLine = lines.length;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        jtf.setForeground(Color.WHITE);
        jtf.setBackground(Color.BLACK);
        JPanel top = new JPanel();
        top.setBackground(Color.BLACK);
        top.add(jtf);
        w.container.add(top, BorderLayout.WEST);
        w.setContentPane(w.container);
        w.setVisible(true);
        w.waitClosed();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(jtf.getText().getBytes());
            fos.close();
        } catch (IOException e) {
            System.out.println("Error!");
            JOptionPane.showMessageDialog(null, "Error : save impossible ", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int getLine(String text, int pos) {
        String[] lines = text.split("\n");
        int n = 0;
        for (int i = 0; i < lines.length; i++) {
            n += lines[i].length();
            if (pos < n) {
                return i;
            }
        }
        return 0;
    }

    public static int getEndLine(String text, int line) {
        String[] lines = text.split("\n");
        int n = 0;
        for (int i = 0; i < line + 1; i++) {
            n += lines[i].length();
        }
        return n;
    }
}
