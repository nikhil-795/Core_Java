package org.example.solid.DIP;

//Without DIP (Bad Example)

//low level implementation
class Keyboard {
    public String getInput() {
        return "Keyboard Input";
    }
}

//high level
class Computer {
    private Keyboard keyboard;

    public Computer() {
        this.keyboard = new Keyboard(); // tightly coupled
    }

    public void readInput() {
        System.out.println(keyboard.getInput());
    }
}

public class DIP_Violate_DIP {
    public static void main(String...e){
        Computer computer = new Computer();
        computer.readInput();


    }
}
/**
 * Problems:
 * Computer depends directly on Keyboard (a low-level module).
 * If tomorrow we want to use a Mouse or Touchscreen, we must change the Computer class.
 */