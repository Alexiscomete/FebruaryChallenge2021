package Admin;

public class NotAdmin implements Admin{

    @Override
    public boolean isAdmin(String why) {
        return false;
    }
}
