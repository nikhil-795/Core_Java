package org.example.exception_handling;

class ValidationException1 extends RuntimeException {
    public ValidationException1() {
    }

    public ValidationException1(String message) {
        super(message);
    }

    public ValidationException1(Throwable cause) {
        super(cause);
    }

    public ValidationException1(String message, Throwable cause) {
        super(message, cause);
    }
}
class ValidationException extends Exception {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}


class BusinessLogic{

    void payment(int age) throws ValidationException {
        if(age < 18){
            throw new ValidationException("age must be grather than 18");
        }
    }
    void display() throws ValidationException {
        try {
            int i = 10 / 0;
        }catch (ArithmeticException e){
            throw new ValidationException(e.getMessage(),e);
        }
    }

    void print(int pageNumber){
        if(pageNumber <= 0){
            throw new ValidationException1("page number can not be 0 or less than 0");
        }
    }
}
public class UserDefinedException {

    public static void main(String... e)  {
        BusinessLogic b = new BusinessLogic();
        try {
            b.payment(18);
            b.display();
        } catch (ValidationException ex) {
          ex.printStackTrace();
        }

        b.print(0);
    }
}
