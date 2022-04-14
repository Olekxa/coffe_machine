package application.engine;

import application.coffe.Coffee;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Machine machine;
    private final Map<String, Coffee> recipeBook;

    public Menu(Scanner scanner, Machine machine, Map<String, Coffee> recipeBook) {
        this.scanner = scanner;
        this.machine = machine;
        this.recipeBook = recipeBook;
    }

    public void run() {
        String result = "";
        boolean control = true;
        while (control) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            var response = scanner.next();
            switch (response) {
                case "buy" -> System.out.println(makingCoffee(result));
                case "fill" -> makeFill();
                case "take" -> System.out.println(machine.take());
                case "remaining" -> System.out.println(machine.status());
                default -> System.out.println("No such command");
                case "exit" -> control = false;
            }
        }
    }

    private String makingCoffee(String result) {
        System.out.println("What do you want to buy? " + parseRicipe() + "back - to main menu:");
        String number = scanner.next();
        switch (number) {
            case "back":
                break;
            default:
                if (recipeBook.containsKey(number)) {
                    result = machine.makeCoffee(recipeBook.get(number));
                } else {
                    result = "There no such type of coffee";
                }
                break;
        }
        return result;
    }

    private String parseRicipe() {
        StringBuilder builder = new StringBuilder();
        for (String s : recipeBook.keySet()) {
            String coffee = recipeBook.get(s).getName();
            builder.append(s + " - " + coffee + ", ");
        }
        return builder.toString();
    }

    private void makeFill() {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cup = scanner.nextInt();
        machine.fill(water, milk, beans, cup);
    }
}
