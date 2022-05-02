package main;

import utility.CollectionManager;
import utility.CommandManager;
import utility.QuestionAboutPerson;
import utility.parser.FromXml;

import java.util.Scanner;

public class Proga {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";
    public static void main(String[] args){//throws JAXBException {
        Scanner userScanner = new Scanner(System.in);
        QuestionAboutPerson questionAboutPerson = new QuestionAboutPerson(userScanner);
        String pathFile = System.getenv("laba_path");
        CollectionManager collectionManager = new CollectionManager(pathFile);
        CommandManager commandManager = new CommandManager(collectionManager,questionAboutPerson);

        if (args.length > 0) {
            FromXml parserFromXml = new FromXml();
            parserFromXml.parse();
            
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду");
            String commandName = input.nextLine();
            commandManager.execute(commandName,pathFile);
        }
    }





}
