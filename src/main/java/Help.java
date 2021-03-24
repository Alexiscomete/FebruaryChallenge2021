import Admin.Admin;

public class Help implements Command {

    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        System.out.println("Help");
        System.out.println("- help : ...");
        System.out.println("- od : open directory on desktop");
        System.out.println("- stop : close");
        System.out.println("- list : content of the directory, add : 's' for files size; 'sd' for sub directories and files size");
        System.out.println("- tree : send the directory tree, add 's' for sub directories and files size, add 'no' after 's' for the not opti mode");
        System.out.println("- cd : change directory, absolute (add / after disk name !) or relative path (../ and ./)");
        System.out.println("- rc : read a file");
        System.out.println("- fe : open file : more option like edit");
        System.out.println("- ef : execute a file !");
    }
}
