package org.example.collectionframework;


import java.util.*;

public class Ex_concurrent_Modification_Exception {

    public static void main(String ...e){
        List<String> list = new ArrayList<>();

        list.add("1");list.add("2");list.add("3");

        System.out.println(list);

        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            //list.add("4");
        }
        System.out.println("list "+list);

        Vector<String> v = new Vector<>();
        v.add("1");v.add("2");v.add("3");
        itr = v.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
           // v.add("4");
        }

        Enumeration<String> enum1 = v.elements();
        while(enum1.hasMoreElements()){
            System.out.println(enum1.nextElement());
            v.add("10");
        }
        System.out.println(v);


    }
}
