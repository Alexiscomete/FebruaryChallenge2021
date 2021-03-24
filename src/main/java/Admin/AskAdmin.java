package Admin;

import java.util.Scanner;

public class AskAdmin implements Admin{

    @Override
    public boolean isAdmin(String why) {
        System.out.println("A program want to: " + why);
        System.out.println("Accept ?");
        System.out.println("Say Yes to accept, other answer to refuse");
        if (new Scanner(System.in).nextLine().toLowerCase().startsWith("yes")) {
            System.out.println("Accept");
            return true;
        }
        System.out.println("Refuse");
        return false;
    }
}
