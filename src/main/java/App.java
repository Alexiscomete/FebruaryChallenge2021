import Admin.Admin;
import Scanners.GetScanner;
import Scanners.MainScanner;
import Admin.AdminList;

public abstract class App {
    public GetScanner sc = new MainScanner();
    public Admin admin = AdminList.YES.ad;
    abstract void mainLoop();
}
