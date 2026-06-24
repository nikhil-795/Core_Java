package org.example.collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest_With_Predefined_object {

    public static void main(String... e){
        List<String> list = new ArrayList<>();

        list.add("1");list.add("2");list.add("3");
        System.out.println("list "+list);
        for(String str: list){
            //for each loop
            System.out.println(str);
        }

        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
           System.out.println(itr.next());
            //itr.remove();
        }
        System.out.println("list "+list);

        ListIterator<String> listIterator = list.listIterator(list.size());
        while(listIterator.hasPrevious()){
           System.out.println(listIterator.previous());
        }

        System.out.println(list.contains("3"));
        list.remove("2");
        System.out.println(list);
        // [1,2,3]
        // [1,3,3]
        // [1,3]
    }
}
