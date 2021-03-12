//import java.awt.*;

import Admin.AdminList;
import Scanners.MainScanner;

public class Main {

    public static void main(String[] args) {
        new MainApp(new MainScanner(), AdminList.YES.ad);
    }
}
