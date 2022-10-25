package Connection;


public class ConnectionManager {
    private static  Connection[] connections;
    private static int current;



    public ConnectionManager(String[] messages) {
        Connection[] tempConnections = new Connection[messages.length];
        for(int i = 0; i < messages.length; i++){
            tempConnections[i] = new Connection(messages[i]);
        }
        connections = tempConnections;
        current = 0;
    }

    public ConnectionManager(int n){
        connections = new Connection[n];
        current = 0;
    }

    public static Connection getConnection(int index){
        assert(index >= 0) : "Negative index";
        assert (index < connections.length) : "Out of range";
        return connections[index];
    }

    public static Connection getConnection(){
        assert (current < connections.length) : "Out of range";
        return connections[current++];
    }

    public Boolean existConnection(){
        return current < connections.length && connections.length != 0;
    }
}
