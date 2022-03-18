package utility;

import classesandenums.Person;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
/**
 * Управляет самой коллекцией.
 */
public class CollectionManager {
        private NavigableSet<Person> personCollection = new LinkedHashSet<>();
        private LocalDateTime lastInitTime;
        private LocalDateTime lastSaveTime;
        private FileManager fileManager;

        public CollectionManager(FileManager fileManager) {
            this.lastInitTime = null;
            this.lastSaveTime = null;
            this.fileManager = fileManager;

            loadCollection();
        }
    /**
     * возращает саму коллекцию.
     */
        public NavigableSet<Person> getCollection() {
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
     * возращает зазмер коллекции.
     */
        public int collectionSize() {
            return personCollection.size();
        }
    /**
     * возращает первый элемент коллекции или null, если коллекция пуста.
     */
        public Person getFirst() {
            if (personCollection.isEmpty()) return null;
            return personCollection.first();
        }
    /**
     * возращает последний элемент коллекции или null, если коллекция пуста.
     */
        public Person getLast() {
            if (personCollection.isEmpty()) return null;
            return personCollection.last();
        }

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

        public double getSumOfHeight() {
            double sumOfHealth = 0;
            for (Person person : personCollection) {
                sumOfHealth += person.getHeight();
            }
            return getSumOfHeight();
        }


        /**
         * @param weaponToFilter Weapon to filter by.
         * @return Information about valid marines or empty string, if there's no such marines.
         */
        public String weaponFilteredInfo(Weapon weaponToFilter) {
            String info = "";
            for (SpaceMarine marine : marinesCollection) {
                if (marine.getWeaponType().equals(weaponToFilter)) {
                    info += marine + "\n\n";
                }
            }
            return info.trim();
        }

        /**
         * Adds a new marine to collection.
         *
         * @param marine A marine to add.
         */
        public void addToCollection(SpaceMarine marine) {
            marinesCollection.add(marine);
        }

        /**
         * Removes a new marine to collection.
         *
         * @param marine A marine to remove.
         */
        public void removeFromCollection(SpaceMarine marine) {
            marinesCollection.remove(marine);
        }

        /**
         * Remove marines greater than the selected one.
         *
         * @param marineToCompare A marine to compare with.
         */
        public void removeGreater(SpaceMarine marineToCompare) {
            marinesCollection.removeIf(marine -> marine.compareTo(marineToCompare) > 0);
        }

        /**
         * Clears the collection.
         */
        public void clearCollection() {
            marinesCollection.clear();
        }

        /**
         * Generates next ID. It will be (the bigger one + 1).
         *
         * @return Next ID.
         */
        public Long generateNextId() {
            if (marinesCollection.isEmpty()) return 1L;
            return marinesCollection.last().getId() + 1;
        }

        /**
         * Saves the collection to file.
         */
        public void saveCollection() {
            fileManager.writeCollection(marinesCollection);
            lastSaveTime = LocalDateTime.now();
        }

        /**
         * Loads the collection from file.
         */
        private void loadCollection() {
            marinesCollection = fileManager.readCollection();
            lastInitTime = LocalDateTime.now();
        }

        @Override
        public String toString() {
            if (marinesCollection.isEmpty()) return "Коллекция пуста!";

            String info = "";
            for (SpaceMarine marine : marinesCollection) {
                info += marine;
                if (marine != marinesCollection.last()) info += "\n\n";
            }

        }
    }
}