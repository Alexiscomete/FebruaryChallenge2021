public class Help extends Command{

    @Override
    public void execute(String[] args, String command) {
        System.out.println("Help");
        System.out.println("- help : ...\n- od : open directory on desktop\n- stop : close\n- list : content of the directory, add : s for files size; sd for sub directories and files size");
    }
}
