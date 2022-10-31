package Connection;

public class Connection {
    private final String message;
    public Connection(){
        this.message = "No message";
    }

    public Connection(String s){
        this.message = s;
    }

    public void show(){
        System.out.println("connection message: " + message);
    }
}

