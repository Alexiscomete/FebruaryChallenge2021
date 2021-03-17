import Admin.Admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

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
        WindowF w = new WindowF("FileEdit", maxSize * 15, strings.length * 25);
        jtf.setForeground(Color.WHITE);
        jtf.setBackground(Color.BLACK);
        JPanel top = new JPanel();
        top.setBackground(Color.BLACK);
        top.add(jtf);
        w.container.add(top, BorderLayout.NORTH);
        w.setContentPane(w.container);
        w.setVisible(true);
    }
}
