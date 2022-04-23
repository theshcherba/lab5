package utility.parser;

import classesandenums.Person;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class FromXml {
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

    static LinkedHashSet<Person> collectionList = new LinkedHashSet<>();
//    private Long id = 1L;
//    private String name = "", car = "", soundtrack = "", weaponType = "";
//    private Float x = Float.valueOf(1000000), y = Float.valueOf(1000000);
//    private Boolean realHero = null, hasToothpick = null;
//    private Long impactSpeed = null;
//    private Integer minutesOfWaiting = null;

    public static LinkedHashSet<Person> readCollection() {
        return collectionList;
    }

    public boolean check() {//ЗДЕСЬ НУЖНО СДЕЛАТЬ ВАЛИДАТОР
        return false;
    }

    public void addToCollection() {
        Person element = new Person();//конструктор
        collectionList.add(element);
    }

    public void parser() {

        File file = new File("Попытка.txt");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc;

        try {
            doc = (Document) dbf.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла" + e.toString());
            return;
        }

        NodeList collection = doc.getElementsByTagName(TAG_ELEMENT);

        for (int i = 0; i < collection.getLength(); i++) {
            if (collection.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            NodeList collectionChildren = collection.item(i).getChildNodes();
            for (int j = 0; j < collectionChildren.getLength(); j++) {
                if (collectionChildren.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (collectionChildren.item(j).getNodeName()) {
                    case TAG_NAME -> name = collectionChildren.item(j).getTextContent();

                    case TAG_COORDINATE_X -> x = Float.parseFloat(collectionChildren.item(j).getTextContent());

                    case TAG_COORDINATE_Y -> y = Float.parseFloat(collectionChildren.item(j).getTextContent());

                    case TAG_REAL_HERO -> realHero = Boolean.parseBoolean(collectionChildren.item(j).getTextContent());

                    case TAG_HAS_TOOTHPICK -> hasToothpick = Boolean.parseBoolean(collectionChildren.item(j).getTextContent());

                    case TAG_IMPACT_SPEED -> impactSpeed = Long.parseLong(collectionChildren.item(j).getTextContent());

                    case TAG_SOUNDTRACK_NAME -> soundtrack = collectionChildren.item(j).getTextContent();

                    case TAG_MINUTES_OF_WAITING -> minutesOfWaiting = Integer.parseInt(collectionChildren.item(j).getTextContent());

                    case TAG_WEAPON_TYPE -> weaponType = collectionChildren.item(j).getTextContent();

                    case TAG_CAR -> car = collectionChildren.item(j).getTextContent();
                }
            }

            if (check()) {
                addToCollection();
                id++;
            }
        }

    }
}