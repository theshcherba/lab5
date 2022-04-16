package utility;

import classesandenums.Location;
import classesandenums.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class CollectionManager {
            static private LinkedHashSet<Person> personCollection = new LinkedHashSet<>();
            private LocalDateTime lastInitTime;
            private LocalDateTime lastSaveTime;
            private FileManager fileManager;

            public CollectionManager(FileManager fileManager) {
                this.lastInitTime = null;
                this.lastSaveTime = null;
                this.fileManager = fileManager;

                loadCollection();//Загружает коллекцию из файла
            }

            public LinkedHashSet<Location> findUniqueLocation() {
                Iterator<Person> iterator = personCollection.iterator();
                LinkedHashSet<Location> uniqueLocations = null;
                while (iterator.hasNext()) {
                    Person person = iterator.next();
                     uniqueLocations = new LinkedHashSet<>();
                    uniqueLocations.add(person.getLocation());
                }
                return uniqueLocations;
            }
             public Object[] LinkedHashSetToArrayList(){
                Object[] people = personCollection.toArray();

                return people;
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
                ArrayList<Person> personArrayList = LinkedHashSetToArrayList();
                return personArrayList.;
            }
            /**
             * возращает последний элемент коллекции или null, если коллекция пуста.
             */
            public Person getLast() {
                if (personCollection.isEmpty()) return null;
                Object[] people = personCollection.toArray();
                Person person = (Person) people[people.length-1];
                return person;
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
                return personCollection.last().getId() + 1;
            }

            /**
             * Сохраняет коллекцию в файл.
             */
            public void saveCollection() {
                fileManager.writeCollection(personCollection);
                lastSaveTime = LocalDateTime.now();
            }

            /**
             * Загружает коллекцию из файла.
             */
            private void loadCollection() {
                personCollection = fileManager.readCollection();
                lastInitTime = LocalDateTime.now();
            }

            public String toString() {
                if (personCollection.isEmpty()) return "Коллекция пуста!";

                String info = "";
                for (Person person : personCollection) {
                    info += person;
                    if (person != personCollection.last()) info += "\n\n";
                }
                return info;
            }


    }
