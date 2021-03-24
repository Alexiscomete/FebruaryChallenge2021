package Admin;

public enum AdminList {

    YES(String -> true),
    NO(String -> false),
    ASK(new AskAdmin());

    public Admin ad;

    AdminList(Admin admin) {
        this.ad = admin;
    }
}
