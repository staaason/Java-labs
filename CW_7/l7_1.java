import Connection.ConnectionManager;

public class l7_1 {
    public static void main(String[] args){
        String[] messages = {"message1", "message2", "message3"};
        ConnectionManager cm = new ConnectionManager(messages);
        while(cm.existConnection()){
            ConnectionManager.getConnection().show();
        }
    }

}
