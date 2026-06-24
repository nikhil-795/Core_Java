package org.example.exception_handling;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class Test{

    void display(String fileName) throws RuntimeException  {
        try {
            InputStream in = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {

        }
    }

    void show() throws IllegalAccessException {
        try{
            int i=10/0;
        }catch (ArithmeticException e){
            throw new IllegalAccessException(e.getMessage());
        }
    }

}
public class checkedException {

    public static void main(String... e) throws IllegalAccessException {
        Test t= new Test();
        t.display("abc");
        t.show();
    }
}
