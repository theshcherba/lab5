package utility;

import java.util.ArrayList;
import java.util.List;

import commands.Command;

    /**
     * Управляет командами.
     */
    public class CommandManager {
        private List<Command> commands = new ArrayList<>();
        private Command helpCommand;
        private Command infoCommand;
        private Command showCommand;
        private Command addCommand;
        private Command updateCommand;
        private Command removeByIdCommand;
        private Command clearCommand;
        private Command saveCommand;
        private Command executeScriptCommand;
        private Command exitCommand;
        private Command addIfMinCommand;
        private Command removeGreaterCommand;
        private Command removeLowerCommand;
        private Command groupCountingByIdCommand;
        private Command filterStartsWithNameCommand;
        private Command printUniqueLocationCommand;

        public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                              Command removeByIdCommand, Command clearCommand, Command saveCommand, Command exitCommand, Command executeScriptCommand,
                              Command addIfMinCommand, Command removeGreaterCommand, Command removeLowerCommand, Command groupCountingByIdCommand,
                              Command filterStartsWithNameCommand, Command printUniqueLocationCommand) {
            this.helpCommand = helpCommand;
            this.infoCommand = infoCommand;
            this.showCommand = showCommand;
            this.addCommand = addCommand;
            this.updateCommand = updateCommand;
            this.removeByIdCommand = removeByIdCommand;
            this.clearCommand = clearCommand;
            this.saveCommand = saveCommand;
            this.executeScriptCommand = executeScriptCommand;
            this.exitCommand = exitCommand;
            this.addIfMinCommand = addIfMinCommand;
            this.removeGreaterCommand = removeGreaterCommand;
            this.removeLowerCommand = removeLowerCommand;
            this.groupCountingByIdCommand = groupCountingByIdCommand;
            this.filterStartsWithNameCommand = filterStartsWithNameCommand;
            this.printUniqueLocationCommand = printUniqueLocationCommand;

            commands.add(helpCommand);
            commands.add(infoCommand);
            commands.add(showCommand);
            commands.add(addCommand);
            commands.add(updateCommand);
            commands.add(removeByIdCommand);
            commands.add(clearCommand);
            commands.add(saveCommand);
            commands.add(executeScriptCommand);
            commands.add(exitCommand);
            commands.add(addIfMinCommand);
            commands.add(removeGreaterCommand);
            commands.add(removeLowerCommand);
            commands.add(groupCountingByIdCommand);
            commands.add(filterStartsWithNameCommand);
            commands.add(printUniqueLocationCommand);
        }

        /**
         *  @возвращает список команд менеджера.
         */
        public List<Command> getCommands() {
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

        /**
         * Выводит описание по доступным командам.
         */
        public boolean help(String argument) {
            if (helpCommand.execute(argument)) {
                for (Command command : commands) {
                    Console.printtable(command.getName(), command.getDescription());
                }
                return true;
            } else return false;
        }

        /**
         * Выводит в стандартный поток вывода информацию о коллекции
         */
        public boolean info(String argument) {
            return infoCommand.execute(argument);
        }

        /**
         * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
         */
        public boolean show(String argument) {
            return showCommand.execute(argument);
        }

        /**
         * Добавляет новый элемент в коллекцию
         */
        public boolean add(String argument) {
            return addCommand.execute(argument);
        }

        /**
         * Обновляет значение элемента коллекции, id которого равен заданному
         */
        public boolean update(String argument) {
            return updateCommand.execute(argument);
        }

        /**
         * Удаляет элемент из коллекции по его id
         */
        public boolean removeById(String argument) {
            return removeByIdCommand.execute(argument);
        }

        /**
         * очищает коллекцию
         */
        public boolean clear(String argument) {
            return clearCommand.execute(argument);
        }

        /**
         * сохраняет коллекцию в файл
         */
        public boolean save(String argument) {
            return saveCommand.execute(argument);
        }

        /**
         * завершает программу
         */
        public boolean exit(String argument) {
            return exitCommand.execute(argument);
        }

        /**
         * считает и исполняет скрипт из указанного файла.
         */
        public boolean executeScript(String argument) {
            return executeScriptCommand.execute(argument);
        }

        /**
         * добавляет новый элемент в коллекцию,
         * если его значение меньше, чем у наименьшего элемента этой коллекции
         */
        public boolean addIfMin(String argument) {
            return addIfMinCommand.execute(argument);
        }

        /**
         * удаляет из коллекции все элементы, превышающие заданный
         */
        public boolean removeGreater(String argument) {
            return removeGreaterCommand.execute(argument);
        }
        /**
         * удаляет из коллекции все элементы, меньшие, чем заданный
         */
        public boolean removeLower(String argument) {
            return removeLowerCommand.execute(argument);
        }
        /**
         * сгруппировывает элементы коллекции по значению поля id,
         * вывести количество элементов в каждой группе
         */
        public boolean groupCountingByI(String argument) {
            return groupCountingByIdCommand.execute(argument);
        }

        /**
         * выводит элементы,
         * значение поля name которых начинается с заданной подстроки
         */
        public boolean filterStartsWithName(String argument) {
            return filterStartsWithNameCommand.execute(argument);
        }

        /**
         * выводит уникальные значения поля location всех элементов в коллекции
         */
        public boolean printUniqueLocation(String argument) {
            return printUniqueLocationCommand.execute(argument);
        }

        public String toString() {
            return "CommandManager (вспомогательный класс для работы с командами)";
        }
    }
