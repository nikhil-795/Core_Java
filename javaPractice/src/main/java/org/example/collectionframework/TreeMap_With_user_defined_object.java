package org.example.collectionframework;


import java.util.Map;
import java.util.TreeMap;

class Trif implements Comparable<Trif>{
    int price;
    String description;
    public Trif(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Trif o) {
        return price - o.price;
    }

    @Override
    public String toString() {
        return "Trif{" +
                "price=" + price +
                '}';
    }
}

public class TreeMap_With_user_defined_object {

    public static void main(String ...e){
        Map<Trif,String> trifStringMap = new TreeMap<>();

        Trif t1 = new Trif(100,"basic");
        Trif t2 = new Trif(500,"basic");
        Trif t3 = new Trif(1000,"Advance");
        Trif t4 = new Trif(1500,"Advance");

        trifStringMap.put(t1,"IN");
        trifStringMap.put(t2,"US");
        trifStringMap.put(t3,"UK");
        trifStringMap.put(t4,"AUS");

        System.out.println(trifStringMap);
    }
}
