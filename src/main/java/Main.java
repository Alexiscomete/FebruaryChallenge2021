//import java.awt.*;

import Admin.AdminList;
import Scanners.MainScanner;

public class Main {

    public static void main(String[] args) {
        load();
    }

    private static void load() {
        try {
            new MainApp(new MainScanner(), AdminList.YES.ad);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Reload ?");
            if (new MainScanner().getScanner().nextLine().equalsIgnoreCase("yes")) {
                new MainApp(new MainScanner(), AdminList.YES.ad);
            } else {
                System.out.println("bye");
            }
        }
    }
}
