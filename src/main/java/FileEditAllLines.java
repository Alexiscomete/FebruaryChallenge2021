import Admin.Admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEditAllLines implements CommandFileEdit {
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
        Font f = new Font("monospace", Font.PLAIN, 18);
        jtf.setFont(f);

        WindowF w = new WindowF("FileEdit", 800, 500) {
            @Override
            public void waitClosed() {
                System.out.println("A window has been open");
                while (wait) {
                    String text = jtf.getText();
                    String[] lines = text.split("\n");
                    if (text.length() > 1) {
                        int pos = jtf.getCaretPosition();
                        int lineI = getLine(text, pos);
                        String line = lines[lineI];
                        if (line.endsWith("{\n") && lines.length > 1) {
                            int n = 0;
                            String line0 = lines[lineI - 1];
                            char c = line0.charAt(0);
                            StringBuilder pre = new StringBuilder();
                            while (c == ' ') {
                                n++;
                                pre.append(" ");
                                c = line0.charAt(n);
                                if (n == line0.length() - 1) {
                                    c = 'a';
                                }
                            }
                            String test = pre + "      \n" + pre + "}";
                            jtf.insert(test, pos);
                            jtf.setCaretPosition(getEndLine(text, lineI));
                        } else if (line.equals("") && lines.length > 1) {
                            int n = 0;
                            String line0 = lines[lineI - 1];
                            char c = line0.charAt(0);
                            StringBuilder pre = new StringBuilder();
                            while (c == ' ') {
                                n++;
                                pre.append(" ");
                                c = line0.charAt(n);
                                if (n == line0.length() - 1) {
                                    c = 'a';
                                }
                            }
                            jtf.insert(String.valueOf(pre), pos);
                            jtf.setCaretPosition(getEndLine(text, lineI));
                        } else if (getNumberOfChar('{', text) != getNumberOfChar('}', text)) {
                            jtf.setForeground(Color.RED);
                        } else {
                            jtf.setForeground(Color.WHITE);
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int maxSize = 0;
                    for (String str : lines) {
                        if (str.length() > maxSize) {
                            maxSize = str.length();
                        }
                    }
                    //jtf.setPreferredSize(new Dimension(200 + maxSize * 10, 200 + lines.length * 10));
                }
            }
        };
        w.setResizable(false);
        jtf.setForeground(Color.WHITE);
        jtf.setBackground(Color.BLACK);
        jtf.setSize(new Dimension(200, 200));
        JScrollPane p = new JScrollPane(jtf);
        p.setPreferredSize(new Dimension(800, 480));
        w.container.add(p, BorderLayout.WEST);
        w.setContentPane(w.container);
        w.setVisible(true);
        w.toFront();
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

    public static int getNumberOfChar(char c, String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c)
                count++;
        }
        return count;
    }
}
