package utility;

public class FileManager {
    private Xml gson = new Gson();
    private String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }
}
