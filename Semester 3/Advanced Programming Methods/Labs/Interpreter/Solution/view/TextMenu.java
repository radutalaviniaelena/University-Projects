package view;

import model.adt.Dict;
import view.command.Command;

import java.util.Scanner;

public class TextMenu {
    private final Dict<String, Command> commands;

    public TextMenu() {
        commands=new Dict<>();
    }

    public void addCommand(Command c) {
        commands.put(c.getKey(), c);
    }

    private void printMenu(){
        for(String command : commands.keySet()){
            String line=String.format("%s:\n%s\n", commands.get(command).getKey(), commands.get(command).getDescription());
            System.out.println(line);
        }
    }

    public void show(){
        Scanner scanner=new Scanner(System.in);
        printMenu();
        //noinspection InfiniteLoopStatement
        while(true){
            System.out.print("Input the option: ");
            String key = scanner.nextLine();
            Command command = commands.get(key);
            if (command == null) {
                System.out.println("Invalid Option");
                continue;
            }
            command.execute();
        }
    }
}