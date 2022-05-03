package main;

import utility.CollectionManager;
import utility.CommandManager;
import utility.QuestionAboutPerson;
import utility.parser.FromXml;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Proga {
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        QuestionAboutPerson questionAboutPerson = new QuestionAboutPerson(userScanner);
        String pathFile = System.getenv("laba_path");
        CollectionManager collectionManager = new CollectionManager(pathFile);
        CommandManager commandManager = new CommandManager(collectionManager, questionAboutPerson);

        try {
            if (pathFile.length() > 0) {
                FromXml parserFromXml = new FromXml();
                parserFromXml.parse(pathFile);
            }
        } catch (NullPointerException exception) {
            System.out.println("File not found");
            return;
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду");
            String commandName = input.nextLine();
            commandManager.execute(commandName, pathFile);
        }

    }

}
