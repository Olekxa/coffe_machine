package application.engine;

import application.coffe.Cappuccino;
import application.coffe.Coffee;
import application.coffe.Espresso;
import application.coffe.Latte;

import java.util.Scanner;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cup;
    private int money;

    public Machine() {
        this(400, 540, 120, 9, 550);
    }

    public Machine(int water, int milk, int beans, int cup, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cup = cup;
        this.money = money;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean control = false;
        while (!control) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scanner.next();
            switch (command) {
                case "buy" -> choice();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> status();
                case "exit" -> control = true;
                default -> System.out.println("No such command");
            }
        }
        scanner.close();
    }

    private void choice() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        switch (number) {
            case "1":
                buy(new Espresso());
                break;
            case "2":
                buy(new Latte());
                break;
            case "3":
                buy(new Cappuccino());
                break;
            case "back":
                break;
            default:
                System.out.println("There no such type of coffee");
        }
        scanner.close();
    }

    private void buy(Coffee coffee) {
        boolean check = checkResource(coffee);
        if (check) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= coffee.getWater();
            milk -= coffee.getMilk();
            beans -= coffee.getBeans();
            money += coffee.getPrice();
            cup--;
        }
    }

    private boolean checkResource(Coffee coffee) {
        if (water - coffee.getWater() < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk - coffee.getMilk() < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans - coffee.getBeans() < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (cup - 1 < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else return true;
    }

    private void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cup += scanner.nextInt();
        scanner.close();
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void status() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cup + " disposable cups");
        System.out.println("$" + money + " of money");
    }

}
