import javax.swing.*;
import java.awt.*;

public abstract class WindowF extends JFrame {
    public JPanel container = new JPanel();
    public Boolean wait = true;

    public WindowF(String name, int x, int y) {
        this.setTitle(name);
        this.setName(name);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container.setBackground(Color.BLACK);
        container.setLayout(new BorderLayout());
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                wait = false;
            }
        });
    }

    public abstract void waitClosed();
}
