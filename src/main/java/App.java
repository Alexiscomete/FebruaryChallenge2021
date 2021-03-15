import Admin.Admin;
import Scanners.GetScanner;
import Scanners.MainScanner;
import Admin.IsAdmin;

public abstract class App {
    public GetScanner sc = new MainScanner();
    public Admin admin = new IsAdmin();
    abstract void mainLoop();
}
