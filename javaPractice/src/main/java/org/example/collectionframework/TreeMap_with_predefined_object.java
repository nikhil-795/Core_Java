package org.example.collectionframework;


import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap_with_predefined_object {
    public static void main(String ...e){
        Map<String,String> treemap = new TreeMap<>();
        treemap.put("1","Raj");
        treemap.put("2","Gurupreet");
        treemap.put("4","Aman");
        treemap.put("3","suresh");
        treemap.put("5","nikhil");

        System.out.println(treemap.put("5","NK"));
        System.out.println(treemap);

        Iterator<String> itr = treemap.keySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
          //  treemap.put("dfdf","dfdf");// java.util.ConcurrentModificationExceptio
        }
    }
}
