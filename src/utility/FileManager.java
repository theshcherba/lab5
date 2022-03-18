package utility;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class FileManager {
    private File file;
    private String envVariable;

    public FileManager(File file, String envVariable) {
        this.envVariable = envVariable;
        this.file = file;
    }
 //   public void callCommand() throws IOException, JAXBException, ClassNotFoundException {
   //     collection = new XmlParser().parseCollection(file);


