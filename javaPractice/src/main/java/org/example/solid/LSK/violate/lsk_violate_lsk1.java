package org.example.solid.LSK.violate;

class user {
    void getAccessLevel(){
        System.out.println("read-only");
    }

    void getRole(){
        System.out.println("user role");
    }
}

class Admin extends user {

    @Override
    void getAccessLevel(){
        System.out.println("Update");
    }

    @Override
    void getRole(){
        System.out.println("admin role");
    }
}

class Manager extends user{

    @Override
    void getAccessLevel(){
        System.out.println("partial");
    }

    @Override
    void getRole(){
        System.out.println("manager role");
    }
}


class Customer extends user {

    @Override
    void getAccessLevel() {
        // customer has no accesslevel in the application
        try {
            // here we can clearly see liskov get violated in this method, it is
            // narrow down the capability of getAccessLevel of super/parent class by raising exaception
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void getRole() {
        System.out.println("customer role");
    }

}

public class lsk_violate_lsk1 {
    public static void main(String... e){

        user u = new user();
        u.getAccessLevel();
        u.getRole();

        u = new Admin();
        u.getAccessLevel();
        u.getRole();

        u = new Manager();
        u.getAccessLevel();
        u.getRole();

        u = new Customer();
        u.getRole();
        u.getAccessLevel(); // we can't substitute instance of super/parent class by the
        // instance of sub-class named customer

    }
}
