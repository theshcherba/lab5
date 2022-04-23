package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import commands.*;

/**
 * Управляет командами.
 */
public class CommandManager {
    private HashMap<String, Command> commands;


    public CommandManager(CollectionManager collectionManager, QuestionAboutPerson questionAboutPerson) {
        commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("add", new AddCommand(collectionManager, questionAboutPerson));
        commands.put("update", new UpdateCommand(collectionManager, questionAboutPerson));
        commands.put("remove_by_ID", new RemoveByIdCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("add_if_min", new AddIfMinCommand(collectionManager, questionAboutPerson));
        commands.put("remove_greater", new RemoveGreaterCommand(collectionManager, questionAboutPerson));
        commands.put("group_counting_by_id", new GroupCountingByIdCommand());
        commands.put("filter_starts_with_name", new FilterStartsWithNameCommand());
        commands.put("print_unique_location", new PrintUniqueLocationCommand(collectionManager, questionAboutPerson));
        commands.put("exit", new ExitCommand());
    }

    public void execute(String commandName, String arguments) {
        Command command = commands.get(commandName);
        command.execute(arguments);
    }

    /**
     * @возвращает список команд менеджера.
     */
    public HashMap<String, Command> getCommands() {
        return commands;
    }

    /**
     * Показывает, что команда не найдена.
     * Возращает состояние(статус) команды.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Напишите 'help', чтобы узнать какие команды есть в этой программе.");
        return false;
    }

//    /**
//     * Выводит описание по доступным командам.
//     */
//    public boolean help(String argument) {
//        if (helpCommand.execute(argument)) {
//            for (Command command : commands) {
//                Console.printtable(command.getName(), command.getDescription());
//            }
//            return true;
//        } else return false;
//    }
//
//    /**
//     * Выводит в стандартный поток вывода информацию о коллекции
//     */
//    public boolean info(String argument) {
//        return infoCommand.execute(argument);
//    }
//
//    /**
//     * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
//     */
//    public boolean show(String argument) {
//        return showCommand.execute(argument);
//    }
//
//    /**
//     * Добавляет новый элемент в коллекцию
//     */
//    public boolean add(String argument) {
//        return addCommand.execute(argument);
//    }
//
//    /**
//     * Обновляет значение элемента коллекции, id которого равен заданному
//     */
//    public boolean update(String argument) {
//        return updateCommand.execute(argument);
//    }
//
//    /**
//     * Удаляет элемент из коллекции по его id
//     */
//    public boolean removeById(String argument) {
//        return removeByIdCommand.execute(argument);
//    }
//
//    /**
//     * очищает коллекцию
//     */
//    public boolean clear(String argument) {
//        return clearCommand.execute(argument);
//    }
//
//    /**
//     * сохраняет коллекцию в файл
//     */
//    public boolean save(String argument) {
//        return saveCommand.execute(argument);
//    }
//
//    /**
//     * завершает программу
//     */
//    public boolean exit(String argument) {
//        return exitCommand.execute(argument);
//    }
//
//    /**
//     * считает и исполняет скрипт из указанного файла.
//     */
//    public boolean executeScript(String argument) {
//        return executeScriptCommand.execute(argument);
//    }
//
//    /**
//     * добавляет новый элемент в коллекцию,
//     * если его значение меньше, чем у наименьшего элемента этой коллекции
//     */
//    public boolean addIfMin(String argument) {
//        return addIfMinCommand.execute(argument);
//    }
//
//    /**
//     * удаляет из коллекции все элементы, превышающие заданный
//     */
//    public boolean removeGreater(String argument) {
//        return removeGreaterCommand.execute(argument);
//    }
//
//    /**
//     * удаляет из коллекции все элементы, меньшие, чем заданный
//     */
//    public boolean removeLower(String argument) {
//        return removeLowerCommand.execute(argument);
//    }
//
//    /**
//     * сгруппировывает элементы коллекции по значению поля id,
//     * вывести количество элементов в каждой группе
//     */
//    public boolean groupCountingById(String argument) {
//        return groupCountingByIdCommand.execute(argument);
//    }
//
//    /**
//     * выводит элементы,
//     * значение поля name которых начинается с заданной подстроки
//     */
//    public boolean filterStartsWithName(String argument) {
//        return filterStartsWithNameCommand.execute(argument);
//    }
//
//    /**
//     * выводит уникальные значения поля location всех элементов в коллекции
//     */
//    public boolean printUniqueLocation(String argument) {
//        return printUniqueLocationCommand.execute(argument);
//    }
//
//    public String toString() {
//        return "CommandManager (вспомогательный класс для работы с командами)";
//    }
}
