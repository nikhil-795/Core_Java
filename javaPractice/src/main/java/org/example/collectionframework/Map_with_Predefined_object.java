package org.example.collectionframework;

import java.util.*;

public class Map_with_Predefined_object {
    public static void main(String... e){
        Map<Number,String> map = new HashMap<>();
        map.put(1,"G");
        map.put(2,"N");
        map.put(3,"A");
        System.out.println(map);

        //map.remove(1);
        System.out.println(map);

        System.out.println(map.containsKey(2));
        System.out.println(map.containsKey(4));
        System.out.println(map.size());

        System.out.println(map.get(3));

        Set<Number> keys = map.keySet();
        System.out.println(keys);

        //keys.add(5); // read only
        //keys.remove(1); // can be removed
        System.out.println("keys after adding into setkey "+keys);

        System.out.println("map "+map);

        Collection<String> values = map.values();
        System.out.println(values);

        //values.add("df"); // read-only
        //values.remove("G"); // can be removed
        System.out.println("after remove value on values() collection "+values);
        System.out.println(map.containsValue("N"));
        System.out.println(map.containsValue("n"));

        Set<Map.Entry<Number,String>> entries = map.entrySet();
        System.out.println(entries);

        //entries.add(new AbstractMap.SimpleEntry<>(1, "one")); // read-only

        entries.remove(new AbstractMap.SimpleEntry<>(1, "G"));
        System.out.println("after remove entry on entrySet() collection "+entries);

        Iterator<Map.Entry<Number,String>> itr = entries.iterator();

        while(itr.hasNext()){
            //System.out.println(itr.next());
            Map.Entry<Number,String> entry = itr.next();
            System.out.println(entry);
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}

