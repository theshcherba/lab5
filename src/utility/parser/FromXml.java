package utility.parser;
import java.io.File;
import java.util.LinkedHashSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import classesandenums.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FromXml{
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_COORDINATE_X = "coordinate_x";
    private static final String TAG_COORDINATE_Y = "coordinate_y";
    private static final String TAG_CREATION_DATE = "creation_date";
    private static final String TAG_HEIGHT = "height";
    private static final String TAG_EYE_COLOR = "eye_color";
    private static final String TAG_HAIR_COLOR = "hair_color";
    private static final String TAG_NATIONALITY = "nationality";
    private static final String TAG_LOCATION_X = "location_x";
    private static final String TAG_LOCATION_Y = "location_y";
    private static final String TAG_LOCATION_Z = "location_z";
    private static final String TAG_LOCATION_NAME = "location_name";
    static LinkedHashSet<Person> collectionList = new LinkedHashSet<>();

    public void parse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        File file = new File("/C://Users//Admin//XML example//src//file1.xml//");
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("person");
            for (int i = 0; i < nodeList.getLength(); i++) {
                collectionList.add(getPerson(nodeList.item(i)));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    // создаем из узла документа объект Person
    private static Person getPerson(Node node) {
        Person person = new Person(0L, "name", new Coordinates(0, 0L), , EColor.BLUE, HColor.BLACK, Country.RUSSIA, new Location(0.0, 0, 0L, "none"));
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            person.setName(getTagValue(TAG_NAME, element));
            person.setId(Long.valueOf(getTagValue(TAG_ID, element)));
            Double x = Double.valueOf(getTagValue(TAG_LOCATION_X, element));
            double y = Double.parseDouble(getTagValue(TAG_LOCATION_Y, element));
            Long z = Long.valueOf(getTagValue(TAG_LOCATION_Z, element));
            Location location = new Location(x, y, z, getTagValue(TAG_LOCATION_NAME, element));
            person.setLocation(location);
            double a = Double.parseDouble(getTagValue(TAG_COORDINATE_X, element));
            long b = Long.parseLong(getTagValue(TAG_COORDINATE_Y, element));
            Coordinates coordinates = new Coordinates(a, b);
            person.setCoordinates(coordinates);
            //person.setCreationDate();
            person.setEyeColor(EColor.valueOf(getTagValue(TAG_EYE_COLOR, element)));
            person.setHeight(Integer.parseInt(getTagValue(TAG_HEIGHT, element)));
            person.setHairColor(HColor.valueOf(getTagValue(TAG_HAIR_COLOR, element)));
            person.setNationality(Country.valueOf(getTagValue(TAG_NATIONALITY, element)));
        }

        return person;
    }

    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public static LinkedHashSet<Person> readCollection() {

        return collectionList;
    }

}
