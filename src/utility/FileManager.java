package utility;

import java.io.File;

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

    public static class FileManager {
        private File file;
        private String envVariable;
        private Cat cat;

        public FileManager(File file, String envVariable) {
            this.envVariable = envVariable;
            this.file = file;
        }

        public FileManager(File file, Cat cat) {
            this.file = file;
            this.cat = cat;
        }

        public String create() {
            CollectionXML col = new CollectionXML(cat);
            VehicleCollection.collection.forEach((k,v) -> col.add(k, new VehicleXML(v)));
            Serializer serializer = new Persister();
            serializer.write(col, out);
            return "filepath";
        }
    }
}


