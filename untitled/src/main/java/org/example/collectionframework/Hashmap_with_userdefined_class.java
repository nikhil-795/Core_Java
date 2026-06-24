package org.example.collectionframework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Athelite {

    int age;
    String name;
    String country;

    public Athelite(String name) {
        this.name = name;
    }

    public Athelite(int age, String country, String name) {
        this.age = age;
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athelite athelite = (Athelite) o;
        return Objects.equals(name, athelite.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Athelite{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Hashmap_with_userdefined_class {
    public static void main(String... ee){
        Map<Athelite,String> map = new HashMap<>(20,0.75f);
        //System.out.println(map);
        Athelite a1 = new Athelite(50,"IN","Nikhil");
        Athelite a2 = new Athelite(60,"Bhutan","Aman");
        Athelite a3 = new Athelite(30,"Luxmbergue","Gurupreet");

        map.put(a1,"football");
        map.put(a2,"Muthhi-marna");
        map.put(a3,"moj");

        for (int i = 1; i <= 50; i++) {
            Athelite ath = new Athelite(20 + i, "Country" + i, "Player" + i);
            map.put(ath, "Sport" + i);
        }

        System.out.println(map);
        System.out.println(map.size());
        Athelite rem = new Athelite("Aman");
        map.remove(rem);
        System.out.println(map);

        Athelite rem1 = new Athelite("Nikhil");
        System.out.println(map.containsKey(rem1));

        System.out.println(map.get(rem1));

       String val =  map.put(a1,"basket-ball");
        System.out.println("val is "+val);
        System.out.println(map);

    }
}
