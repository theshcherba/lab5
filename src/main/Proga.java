package main;

import classesandenums.*;
import utility.CollectionManager;
import utility.CommandManager;
import utility.QuestionAboutPerson;
import utility.parser.FromXml;

import javax.xml.bind.JAXBException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Proga {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";
    public static void main(String[] args){//throws JAXBException {
        Scanner userScanner = new Scanner(System.in);
        QuestionAboutPerson questionAboutPerson = new QuestionAboutPerson(userScanner);
        String pathFile = new ;
        CollectionManager collectionManager = new CollectionManager(pathFile);
        CommandManager commandManager = new CommandManager(collectionManager,questionAboutPerson);

        if (args.length > 0) {
            FromXml parserFromXml = new FromXml();
            parserFromXml.parser();
            collectionManager.personCollection(FromXml.readCollection());
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду");
            String commandName = input.nextLine();
            commandManager.execute(commandName);
        }
    }
//        String path;
//        try{
//            path = args[0];
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Вы не ввели путь к коллекции при запуске, используем чистую коллекцию.");
//            path = "";
//        }
//        Person person = new Person(336493L,"Rodin",new Coordinates(343,434), LocalDateTime.now(),  45, EColor.BLUE, HColor.BLACK,Country.RUSSIA,
//                new Location(new Double(323),434,343443L,"Novo"));
//        String arguments = args[0];




    }
}
