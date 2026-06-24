package org.example.solid.DIP;

// Abstraction
interface InputDevice {
    String getInput();
}

// Low-level module 1
class Keyboard1 implements InputDevice {
    public String getInput() {
        return "Keyboard Input";
    }
}

// High-level module depends on abstraction
class Computer1 {
    private InputDevice inputDevice;

    public Computer1(InputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }

    public void readInput() {
        System.out.println(inputDevice.getInput());
    }
}

// Low-level module 2
class Mouse implements InputDevice {
    public String getInput() {
        return "Mouse Input";
    }
}

public class DIP_With_DIP {

    public static void main(String...e){
        InputDevice keyboard = new Keyboard1();
        Computer1 computer1 = new Computer1(keyboard);
        computer1.readInput();

        InputDevice mouse = new Mouse();
        Computer1 computer2 = new Computer1(mouse);
        computer2.readInput();
    }
}
