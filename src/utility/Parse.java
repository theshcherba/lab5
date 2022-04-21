package utility;

import classesandenums.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Parse {
    public static void convertObjectToXml(Person person, String pathFile) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(person, new File(pathFile));
        } catch (JAXBException e) {
            System.err.println("Какая ошибка?");
        }

    }

    public static CollectionManager convertXmlToObject(String pathFile) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CollectionManager people = (CollectionManager) unmarshaller.unmarshal(new File(pathFile));
            for (int i = 0; i < people.collectionSize(); i++) {
//                Validator validator = new Validator(Flat.class);
//                if(!validator.validate(flats.getFlats().get(i))){
//                    System.out.printf("В %d квартире найдена ошибка в файле. В файле startData.xml введны некорректные данные.\n",i+1);
//                    flats.removeId((long) i);
            }
            return people;
        } catch (JAXBException e) {
            System.err.println("Какая ошибка?");
        }
        return null;
    }

}