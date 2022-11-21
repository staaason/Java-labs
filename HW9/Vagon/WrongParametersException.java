package Vagon;

public class WrongParametersException extends IllegalArgumentException{


    @Override
    public String toString() {
        return message ;
    }

    private final String message;
    public WrongParametersException(String message) {
        this.message = message;
    }
}
