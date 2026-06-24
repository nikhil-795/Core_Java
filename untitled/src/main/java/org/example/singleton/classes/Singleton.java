package org.example.singleton.classes;

import java.util.Objects;

//not full proof singleton
class FirstSingleton {

    private static FirstSingleton instance;

    private FirstSingleton(){
        System.out.println("default constructor...........");
    }

    public static FirstSingleton getInstance(){
        if(Objects.isNull(instance)){
            System.out.println("1");
            instance =  new FirstSingleton();
        }else{
            System.out.println("2");
            return instance;
        }
        System.out.println("3");
        return instance;
    }

}

public class Singleton {

    public static void main(String... r){
        System.out.println(FirstSingleton.getInstance().hashCode());
        System.out.println( FirstSingleton.getInstance().hashCode());

        System.out.println(FirstSingleton.getInstance().hashCode());
        System.out.println( FirstSingleton.getInstance().hashCode());
    }
}
