package org.example.exception_handling;


class Test1{

    //Generalized Exception
    void genException(int value,String number){
        int i=0;
        try{
            i = 10/value;
            int v = Integer.parseInt(number);
            v = v+10;
            System.out.println("v is "+v);
        }
        catch (ArithmeticException e){
            System.out.println("exception occurred while dividing by "+value);
        }
        catch (NumberFormatException e){
            System.out.println("exception occurred while NumberFormatException");
        }
        catch (Exception e){
            System.out.println("exception occurred while dividing by "+value);
        }
        finally {
            System.out.println("finally block");
        }
        System.out.println("i is "+i);
    }
    void display(String number){
        int v = Integer.parseInt(number);
        v = v+10;
        System.out.println("v is "+v);
    }

    int show(int value){
        int i=0;
        try{
            i = 10/value;
        }catch (ArithmeticException e){
            System.out.println("exception occurred while dividing by "+value);
        }
        finally {
            System.out.println("finally block");
        }
        System.out.println("i is "+i);
        return i;
    }
}
public class UncheckedException {

    public static void main(String... e){
        Test1 t= new Test1();
        System.out.println(t.show(10));

       // t.display("Guru");

        t.genException(10,"G");
    }
}
