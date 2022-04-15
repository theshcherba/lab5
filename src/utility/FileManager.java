package utility;

import classesandenums.Person;
import main.Proga;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class FileManager {
    private File file;
    private String envVariable;

    public FileManager(File file, String envVariable, String path) {
        this.envVariable = envVariable;
        this.file = file;
    }

    public void createFile() throws JAXBException {
//        if(equals(null)) {
//            JAXBContext context = JAXBContext.newInstance(Person.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(context, file);
//            marshaller.marshal(, file);
//            marshaller.marshal(Person p, );
//        }
    }
    public void readFile() {


    }

}



