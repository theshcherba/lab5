package main;

import classesandenums.*;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Proga {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";
    public static void main(String[] args) throws JAXBException {
        String path;
        try{
            path = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели путь к коллекции при запуске, используем чистую коллекцию.");
            path = "";
        }
        Person person = new Person(336493L,"Rodin",new Coordinates(343,434), LocalDateTime.now(),  45, EColor.BLUE, HColor.BLACK,Country.RUSSIA,
                new Location(new Double(323),434,343443L,"Novo"));//
        String arguments = args[0];
        File file  = new File("example.xml");
        if(arguments.equals(null)) {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(context, file);
            marshaller.marshal(person, file);
            marshaller.marshal(person,System.out);
        }



    }
}
