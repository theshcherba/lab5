package commands;

import classesandenums.Person;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.PersonNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.QuestionAboutPerson;

import java.time.LocalDateTime;

public class GroupCountingByIdCommand extends AbstractCommand {
    private CollectionManager collectionManager;
public GroupCountingByIdCommand(CollectionManager collectionManager){
    super("group_counting_by_id","сгруппировать элементы коллекции по значению ID поля");
    this.collectionManager = collectionManager;
}
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
        } catch (){

        }
        return false;
    }
}
