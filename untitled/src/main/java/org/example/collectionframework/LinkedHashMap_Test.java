package org.example.collectionframework;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap_Test {
    public static void main(String... e){
        Map<String,String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("1","Nikjhi");
        linkedHashMap.put("2","Gurupreet");
        linkedHashMap.put("3","Aman");
        System.out.println(linkedHashMap);

        linkedHashMap.get("1");

        System.out.println(linkedHashMap);

        linkedHashMap.get("2");

        System.out.println(linkedHashMap);


    }
}
