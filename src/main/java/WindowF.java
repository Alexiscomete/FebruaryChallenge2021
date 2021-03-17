import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class WindowF extends JFrame implements WindowListener {
    public JPanel container = new JPanel();
    public static HashMap<String, Boolean> windows = new HashMap<>();

    public WindowF(String name, int x, int y) {
        this.setTitle(name);
        this.setName(name);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container.setBackground(Color.BLACK);
        container.setLayout(new BorderLayout());
        windows.put(name, true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window open: " + e.getWindow().getName());
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing: " + e.getWindow().getName());
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed: " + e.getWindow().getName());
        windows.replace(e.getWindow().getName(), false);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("I am a cake");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("I am a Minecraft server");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("I am a Discord server");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("I am a ... I don't know");
    }

    public void waitClosed() {
        int i = 100; //pour éviter de manger tout le processeur
        boolean test = true;
        while (test) {
            i--;
            if (i == 0) {
                test = windows.get(this.getName());
                i = 100;
            }
        }
        windows.remove(this.getName());
    }
}
