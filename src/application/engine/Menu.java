package application.engine;

import application.coffe.Coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Machine machine;

    public Menu(Machine machine) {
        this.machine = machine;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String result = "";
        boolean control = true;
        while (control) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            var response = scanner.next();
            switch (response) {
                case "buy" -> System.out.println(makingCoffee(scanner, machine, result));
                case "fill" -> makeFill(scanner, machine);
                case "take" -> System.out.println(machine.take());
                case "remaining" -> System.out.println(machine.status());
                default -> System.out.println("No such command");
                case "exit" -> control = false;
            }
        }
        scanner.close();
    }

    private String makingCoffee(Scanner scanner, Machine machine, String result) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Map<String, Coffee> recipeCoffee = recipeCoffee();
        String number = scanner.next();
        switch (number) {
            case "1":
                result = machine.makeCoffee(recipeCoffee.get("espresso"));
                break;
            case "2":
                result = machine.makeCoffee(recipeCoffee.get("latte"));
                break;
            case "3":
                result = machine.makeCoffee(recipeCoffee.get("cappuccino"));
                break;
            case "back":
                break;
            default:
                result = "There no such type of coffee";
                break;
        }
        return result;
    }

    private Map<String, Coffee> recipeCoffee() {
        Map<String, Coffee> recipeCoffee = new HashMap<>();
        recipeCoffee.put("espresso", new Coffee(250, 0, 16, 4));
        recipeCoffee.put("latte", new Coffee(350, 75, 20, 7));
        recipeCoffee.put("cappuccino", new Coffee(200, 100, 12, 6));
        return recipeCoffee;
    }

    private void makeFill(Scanner scanner, Machine machine) {
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
