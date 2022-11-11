package QuadraticEquation;

public class SqrEqnException extends ArithmeticException{
    @Override
    public String toString() {
        return detail;
    }

    private final String detail;
    SqrEqnException(String message){
        detail = message;
    }

}
