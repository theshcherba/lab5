package utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class FileManager {
    private File file;
    private String envVariable;

    public FileManager(File file, String envVariable) {
        this.envVariable = envVariable;
        this.file = file;
    }
    /*нужно сверить две лабы и вытащить где xml нужное и писать дальше по первой
    public void callCommand() throws IOException, JAXBException, ClassNotFoundException {
        collection = new XmlParser().parseCollection(file);
        Scanner sc = new Scanner(System.in);
        String commands;
        System.out.println("vvedite comandy");
        while ((commands = sc.nextLine()) != "exit") {

            String result = stringToObject.getObjectCommand(commands).execute(collection);
            System.out.println(result);

     */

//    public static class FileManager {
//        private File file;
//        private String envVariable;
//
//
//        public FileManager(File file, String envVariable) {
//            this.envVariable = envVariable;
//            this.file = file;
//        }
//
//        public FileManager(File file) {
//            this.file = file;
//        }

        public String create() throws ParserConfigurationException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element rootEl = document.createElement("people");
            return null;
            //Element

//            CollectionXML col = new CollectionXML(cat);
//            VehicleCollection.collection.forEach((k,v) -> col.add(k, new VehicleXML(v)));
//            Serializer serializer = new Persister();
//            serializer.write(col, out);
//            return "filepath";
        }
    }


