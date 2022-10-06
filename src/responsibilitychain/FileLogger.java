package responsibilitychain;

/**
 * @author Ruobing Shang 2022-10-06 15:50
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
