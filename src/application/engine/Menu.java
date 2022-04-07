package application.engine;

import application.coffe.Coffee;

import java.util.Scanner;

public class Menu {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        String result = "";
        boolean control = true;
        while (control) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            var response = scanner.next();
            switch (response) {
                case "buy":
                    result = makingCoffee(scanner, machine, result);
                    break;
                case "fill":
                    makeFill(scanner, machine);
                    result ="";
                    break;
                case "take":
                    result = machine.take();
                    break;
                case "remaining":
                    result = machine.status();
                    break;
                default:
                    result = "No such command";
                case "exit":
                    control = false;
            }
            System.out.println(result);
        }
        scanner.close();
    }

    private String makingCoffee(Scanner scanner, Machine machine, String result) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String number = scanner.next();
        switch (number) {
            case "1":
                result = machine.buy(new Coffee(250, 0, 16, 4));
                break;
            case "2":
                result = machine.buy(new Coffee(350, 75, 20, 7));
                break;
            case "3":
                result = machine.buy(new Coffee(200, 100, 12, 6));
                break;
            case "back":
                break;
            default:
                result = "There no such type of coffee";
                break;
        }
        return result;
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
