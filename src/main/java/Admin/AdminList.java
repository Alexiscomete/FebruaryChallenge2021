package Admin;

public enum AdminList {

    YES(new IsAdmin()),
    NO(new NotAdmin()),
    ASK(new AskAdmin());

    public Admin ad;

    AdminList(Admin admin) {
        this.ad = admin;
    }
}
