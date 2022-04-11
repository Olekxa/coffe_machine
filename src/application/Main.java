package application;

import application.engine.Machine;
import application.engine.Menu;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine(400, 540, 120, 9, 550);
        Menu menu = new Menu(machine);
        menu.run();
    }
}
