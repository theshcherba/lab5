package utility.parser;

import classesandenums.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utility.CollectionManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.LinkedHashSet;

public class ToXml {
    private static final String TAG_ID = "id";
    private static final String TAG_CREATION_DATE = "creation_date";
    private static final String TAG_NAME = "name";
    private static final String TAG_COORDINATE_X = "coordinate_x";
    private static final String TAG_COORDINATE_Y = "coordinate_y";
    private static final String TAG_REAL_HERO = "real_hero";
    private static final String TAG_HAS_TOOTHPICK = "has_toothpick";
    private static final String TAG_IMPACT_SPEED = "impact_speed";
    private static final String TAG_SOUNDTRACK_NAME = "soundtrack_name";
    private static final String TAG_MINUTES_OF_WAITING = "minutes_of_waiting";
    private static final String TAG_WEAPON_TYPE = "weapon_type";
    private static final String TAG_CAR = "car";
    private static final String TAG_ELEMENT = "element";
    private static final String TAG_COLLECTION = "collection";

    public void writeCollection(LinkedHashSet<Person> personCollection, String path) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element elementCollection = doc.createElement(TAG_COLLECTION);
            doc.appendChild(elementCollection);

            for (Person person : personCollection) {
                Element element = doc.createElement(TAG_ELEMENT);
                elementCollection.appendChild(element);

                Element elementId = doc.createElement(TAG_ID);
                elementId.appendChild(doc.createTextNode(person.getId().toString()));
                element.appendChild(elementId);

                Element elementName = doc.createElement(TAG_NAME);
                elementName.appendChild(doc.createTextNode(person.getName()));
                element.appendChild(elementName);

                Element elementRealHero = doc.createElement(TAG_REAL_HERO);
                elementRealHero.appendChild(doc.createTextNode(person.getRealHero().toString()));
                element.appendChild(elementRealHero);

                Element elementHasToothpick = doc.createElement(TAG_HAS_TOOTHPICK);
                elementHasToothpick.appendChild(doc.createTextNode(person.getHasToothpick().toString()));
                element.appendChild(elementHasToothpick);

                Element elementImpactSpeed = doc.createElement(TAG_IMPACT_SPEED);
                elementImpactSpeed.appendChild(doc.createTextNode(person.getImpactSpeed().toString()));
                element.appendChild(elementImpactSpeed);

                Element elementMinutesOfWaiting = doc.createElement(TAG_MINUTES_OF_WAITING);
                elementMinutesOfWaiting.appendChild(doc.createTextNode(person.getMinutesOfWaiting().toString()));
                element.appendChild(elementMinutesOfWaiting);

                Element elementCar = doc.createElement(TAG_CAR);
                elementCar.appendChild(doc.createTextNode(person.getCar().toString()));
                element.appendChild(elementCar);

                Element elementSoundtrack = doc.createElement(TAG_SOUNDTRACK_NAME);
                elementSoundtrack.appendChild(doc.createTextNode(person.getSoundtrackName()));
                element.appendChild(elementSoundtrack);

                Element elementWeaponType = doc.createElement(TAG_WEAPON_TYPE);
                elementWeaponType.appendChild(doc.createTextNode(person.getWeaponType().toString()));
                element.appendChild(elementWeaponType);

                Element elementCoordinateX = doc.createElement(TAG_COORDINATE_X);
                elementCoordinateX.appendChild(doc.createTextNode(person.getCoordinateX().toString()));
                element.appendChild(elementCoordinateX);

                Element elementCoordinateY = doc.createElement(TAG_COORDINATE_Y);
                elementCoordinateY.appendChild(doc.createTextNode(person.getCoordinateY().toString()));
                element.appendChild(elementCoordinateY);

                Element elementCreationDate = doc.createElement(TAG_CREATION_DATE);
                elementCreationDate.appendChild(doc.createTextNode(person.getCreationDate().toString()));
                element.appendChild(elementCreationDate);
            }

            File file = new File("result.xml");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
