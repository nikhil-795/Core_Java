package org.example.exception_handling;


import java.io.*;
import java.util.Scanner;

class MultiCatchStatement{

    void show(int num,String number){
        try {
            int i=10/num;
            int v = Integer.parseInt(number);
        }catch (ArithmeticException | NumberFormatException e) {
            System.out.println("number can be string...");
        }
    }
  /*  void display(int num,String number){
        try {
            int i=10/num;
            int v = Integer.parseInt(number);
            //both are having child-parent relationship
        }*//*catch (ArithmeticException | RuntimeException e) {
            System.out.println("number can be string...");
        }*//*
        //both are having child-parent relationship
        catch (FileNotFoundException | IOException e) {
            System.out.println("number can be string...");
        }
    }*/
}
class FileProcessor {

    void tryWithResource() throws IOException {
        try(InputStream in = new FileInputStream("abc");
            Scanner sc = new Scanner(new File(("abc.txt")))){
            // read
            System.out.println("business logic");
        }
    }
    void tryWithoutResource(){
        InputStream in=null;
        try {
             in = new FileInputStream("abc.txt");
             //read the file
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                System.out.println("into finally");
                if(null != in){
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class try_with_resourece {

    public static void main(String... e) {
        //new FileProcessor().tryWithoutResource();
        new MultiCatchStatement().show(0,"dfd");
    }
}
