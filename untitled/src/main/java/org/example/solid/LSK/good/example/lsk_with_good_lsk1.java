package org.example.solid.LSK.good.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//extract all the common methods of user class and put them into different class
class BaseUser{
    void getRole(){
        System.out.println("base user role");
    }

      List<Integer> list=new List<Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

          @Override
          public boolean add(Integer integer) {
              return false;
          }


        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Integer get(int index) {
            return 0;
        }

          @Override
          public Integer set(int index, Integer element) {
              return null;
          }

          @Override
          public void add(int index, Integer element) {

          }

          @Override
          public Integer remove(int index) {
              return null;
          }


        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            return null;
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
}

class User extends BaseUser{

    @Override
    void getRole(){
        System.out.println("normal user role");
    }

    void getAccessLevel(){
        System.out.println("read-only");
    }
}

class Admin1 extends User {

    @Override
    void getAccessLevel(){
        System.out.println("Update");
    }

    @Override
    void getRole(){
        System.out.println("admin role");
    }
}

class Manager1 extends User{

    @Override
    void getAccessLevel(){
        System.out.println("partial");
    }

    @Override
    void getRole(){
        System.out.println("manager role");
    }
}

class Customer1 extends BaseUser {

    @Override
    void getRole() {
        System.out.println("customer role");
    }

}

public class lsk_with_good_lsk1 {

    public static void main(String... e){

        BaseUser b = new BaseUser();
       // b.getAccessLevel();
        b.getRole();

        User u = new User();
        u.getAccessLevel();
        u.getRole();

        u = new Admin1();
        u.getAccessLevel();
        u.getRole();

        u = new Manager1();
        u.getAccessLevel();
        u.getRole();

        b = new Customer1();
        b.getRole();

    }
}
