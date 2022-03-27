package main;

import java.nio.file.Path;

public class Proga {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";
    public static void main(String[] args) {
        String path;
        try{
            path = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели путь к коллекции при запуске, используем чистую коллекцию.");
            path = "";
            System.out.println("Hello");
        }
    }
}
