import Admin.Admin;

import javax.swing.*;
import java.io.File;

public class FileEditAllLigne extends CommandFileEdit{
    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        JFrame fenetre = new JFrame();
        fenetre.setVisible(true);
    }
}
