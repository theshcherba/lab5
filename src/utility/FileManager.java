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
    //нужно сверить две лабы и вытащить где xml нужное и писать дальше по первой
 //   public void callCommand() throws IOException, JAXBException, ClassNotFoundException {
   //     collection = new XmlParser().parseCollection(file);
    //    Scanner sc = new Scanner(System.in);
     //   String commands;
      //  System.out.println("vvedite comandy");
       // while ((commands = sc.nextLine()) != "exit") {

          //  String result = stringToObject.getObjectCommand(commands).execute(collection);
           // System.out.println(result);
        }


