package Admin;

public class IsAdmin implements Admin{

    @Override
    public boolean isAdmin(String why) {
        return true;
    }
}
