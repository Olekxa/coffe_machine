package application;

import application.coffe.Coffee;
import application.engine.Machine;
import application.engine.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine(400, 540, 120, 9, 550);
        Map<String, Coffee> recipeCoffee = new HashMap<>();
        recipeCoffee.put("1", new Coffee("espresso", 250, 0, 16, 4));
        recipeCoffee.put("2", new Coffee("latte", 350, 75, 20, 7));
        recipeCoffee.put("3", new Coffee("cappuccino", 200, 100, 12, 6));
        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu(scanner, machine, recipeCoffee);
            menu.run();
        }
    }
}
