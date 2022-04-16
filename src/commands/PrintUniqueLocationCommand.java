package commands;

import exceptions.CollectionIsEmptyException;
import utility.CollectionManager;
import utility.QuestionAboutPerson;

public class PrintUniqueLocationCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private QuestionAboutPerson questionAboutPerson;


    public PrintUniqueLocationCommand(CollectionManager collectionManager, QuestionAboutPerson questionAboutPerson) {
        super("print_unique_location","выводит уникальные значения поля location всех элементов в коллекции");
        this.collectionManager = collectionManager;
        this.questionAboutPerson = questionAboutPerson;
    }

    public boolean execute(String argument) {
       try{
           if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

       } catch (CollectionIsEmptyException e) {
           e.printStackTrace();
       }
    }
}
