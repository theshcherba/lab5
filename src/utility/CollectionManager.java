package utility;

import classesandenums.Person;
import utility.parser.FromXml;
import utility.parser.ToXml;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public class CollectionManager {
    private LinkedHashSet<Person> personCollection = new LinkedHashSet<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private ToXml toXml;
    private FromXml fromXml;
    private String pathFile;


    public CollectionManager(String pathFile) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.toXml = null;
        this.fromXml = null;
        this.pathFile = pathFile;
        loadCollection();//Загружает коллекцию из файла
    }

    public Person[] collectionToArray() {
        Object[] arrayObjectPeople = personCollection.toArray();
        Person[] arrayPeople = new Person[arrayObjectPeople.length];
        for (int i = 0; i < arrayPeople.length; i++) {
            arrayPeople[i] = (Person) arrayObjectPeople[i];
        }
        return arrayPeople;
    }

    /**
     * возращает саму коллекцию.
     */
    public LinkedHashSet<Person> getCollection() {
        return personCollection;
    }

    /**
     * возращает время последней инициализации или null, если инициализации не было.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * возращает последнее сохранение времени или ноль, если не было сохранения.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * возращает название типа коллекции.
     */
    public String collectionType() {
        return personCollection.getClass().getName();
    }

    /**
     * возращает размер коллекции.
     */
    public int collectionSize() {
        return personCollection.size();
    }

    /**
     * возращает первый элемент коллекции или null, если коллекция пуста.
     */
    public Person getFirst() {
        if (personCollection.isEmpty()) return null;
        Person[] people = collectionToArray();
        return people[0];
    }

    /**
     * возращает последний элемент коллекции или null, если коллекция пуста.
     */
    public Person getLast() {
        if (personCollection.isEmpty()) return null;
        Person[] people = collectionToArray();
        return people[people.length - 1];
    }

    /**
     * параметр id персона.
     * возвращает персона по его идентификатору или null, если персон не найден.
     */
    public Person getById(Long id) {
        for (Person person : personCollection) {
            if (person.getId().equals(id)) return person;
        }
        return null;
    }

    public Person getByValue(Person personToFind) {
        for (Person person : personCollection) {
            if (person.equals(personToFind)) return person;
        }
        return null;
    }

    /**
     * Добавляет нового персона в коллекцию.
     * Добавяет параметр персона.
     */
    public void addToCollection(Person person) {
        personCollection.add(person);
    }

    /**
     * Удаляет персона из коллекции.
     * Удаляет параметр персона.
     */
    public void removeFromCollection(Person person) {
        personCollection.remove(person);
    }

    /**
     * Удаляет персонов меньше, чем заданный.
     * Параметр personToCompare персона для сравнения.
     */
    public void removeLower(Person personToCompare) {
        personCollection.removeIf(person -> person.compareTo(personToCompare) < 0);
    }

    /**
     * Удаляет персонов больше, чем заданный.
     * Параметр personToCompare персона для сравнения.
     */
    public void removeGreater(Person personToCompare) {
        personCollection.removeIf(person -> person.compareTo(personToCompare) > 0);
    }

    /**
     * Очищает коллекцию.
     */
    public void clearCollection() {
        personCollection.clear();
    }

    /**
     * Генерирует следующий идентификатор. Это будет (больший + 1).
     * Возращает Next ID.
     */
    public Long generateNextId() {
        if (personCollection.isEmpty()) return 1L;
        Person[] people = collectionToArray();
        return people[people.length - 1].getId() + 1;
    }

    /**
     * Сохраняет коллекцию в файл.
     */
    public void saveCollection() {
        toXml.writeCollection(personCollection, pathFile);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Загружает коллекцию из файла.
     */
    private void loadCollection() {
        personCollection = FromXml.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    public String toString() {
        if (personCollection.isEmpty()) return "Коллекция пуста!";
        Person[] people = collectionToArray();
        String info = "";
        for (Person person : personCollection) {
            info += person;
            if (person != people[people.length - 1]) info += "\n\n";
        }
        return info;
    }

}
