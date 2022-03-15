package utility;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.*;


public class FileManager {
    private JAXB xml = new JAXB();
    private String envVariable;
    @XmlType(name= "Student");

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }
}
