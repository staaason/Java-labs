package quadrangle;

public class WrongSideException extends Exception{
    public WrongSideException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String toString() {
        return message;
    }

    private String message;

}
