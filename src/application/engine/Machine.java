package application.engine;

import application.coffe.Coffee;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cup;
    private int money;

    public Machine(int water, int milk, int beans, int cup, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cup = cup;
        this.money = money;
    }

    public void fill(int waterIncome, int milkIncome, int beansIncome, int cupIncome) {
        beans += beansIncome;
        milk += milkIncome;
        water += waterIncome;
        cup += cupIncome;
    }

    public String makeCoffee(Coffee coffee) {
        String check = checkResource(coffee);
        if ("".equals(check)) {
            water -= coffee.getWater();
            milk -= coffee.getMilk();
            beans -= coffee.getBeans();
            money += coffee.getPrice();
            cup--;
            return "I have enough resources, making you a coffee!";
        } else {
            return check;
        }
    }

    public String take() {
        String result = "I gave you $" + money;
        money = 0;
        return result;
    }

    public String status() {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cup + " disposable cups\n" +
                "$" + money + " of money";
    }

    private String checkResource(Coffee coffee) {
        String basis = "Sorry, not enough ";
        if (water - coffee.getWater() < 0) {
            return basis + "water!";
        } else if (milk - coffee.getMilk() < 0) {
            return basis + "milk!";
        } else if (beans - coffee.getBeans() < 0) {
            return basis + "beans!";
        } else if (cup - 1 < 0) {
            return basis + "cup!";
        } else return "";
    }
}
