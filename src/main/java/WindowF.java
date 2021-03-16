import javax.swing.*;
import java.awt.*;

public class WindowF extends JFrame {
    public JPanel container = new JPanel();

    public WindowF(String name, int x, int y) {
        this.setName(name);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container.setBackground(Color.BLACK);
        container.setLayout(new BorderLayout());
    }
}
