package Project;

import java.sql.*;
import java.text.MessageFormat;


/**
 * Represents a model to connect to remote SQL server and do query
 * NOTE: You need to have internet connection and permission to connect
 * @version 27 Nov 2022
 * @since 21 Nov 2022
 */
public class RemoteDBConnection {
    /**
     * Your sql connection in java
     * default: null
     */
    private Connection connection = null;


    /**
     * Hostname for connection to remote SQL server
     */
    private String host;

    /**
     * Number of port for connection
     */
    private String port;

    /**
     * Username for sql server
     */
    private final String username;

    /**
     * User's password for connection
     */
    private String password;

    /**
     * @param host Hostname of server
     * @param port Port number of server
     * @param username Username of user for server
     * @param password User's password for server
     */
    public RemoteDBConnection(String host, String port, String username, String password) throws Exception {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        System.out.println("Connecting to MySql");
        this.connection = connect();
    }


    /**
     * Returns the  SQL connection
     * @return Generic SQL connection
     */
    public Connection getConnection(){
        return this.connection;
    }


    /**
     * Connect to remote SQL server and returns the SQL connection
     * @return Generic SQL connection
     */
    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL =  MessageFormat.format("jdbc:mysql://{0}:{1}/?user={2}", host, port, username);
            this.connection = DriverManager.getConnection(connectionURL, username, password);
            if (connection != null) {
                System.out.println("Connection to SqlServer is  successful");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to SqlServer : " + e);
        } catch (ClassNotFoundException e) {
           System.out.println(e.getMessage());
        }
        return connection;
    }

    /**
     * Override execute query statement which doesn't return ResultSet
     * @param query The query of type PreparedStatement
     */
    public void executeUpdateStatement(PreparedStatement query) throws SQLException{
        if(this.connection == null){
            System.out.println("Connection is null, creating new connection");
            this.connection = connect();
        }
        try {
            int status = query.executeUpdate();
            if(status >= 0){
                System.out.println("Executing query is successful " + query);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Override execute query statement which doesn't return ResultSet
     * @param query The query of type String
     */
    public void executeUpdateStatement(String query) throws SQLException{
        if(this.connection == null){
            System.out.println("Connection is null, creating new connection");
            this.connection = connect();
        }
        try {
            Statement statement = this.connection.createStatement();
            int status = statement.executeUpdate(query);
            if(status >= 0){
                System.out.println("Executing query is successful " + query);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * Execute query statement which return ResultSet
     * @param query The query of type String
     */
    public ResultSet executeSelectQuery(String query) throws SQLException {
        ResultSet rs = null;
        if(this.connection == null){
            System.out.println("Connection is null, creating new connection");
            this.connection = connect();
        }

        try {
            Statement statement = this.connection.createStatement();
            System.out.println("Executing select query " + query);
            rs = statement.executeQuery(query);
            return rs;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    /**
     * Execute query statement SHOW GRANTS and return  user's permission
     */
    public ResultSet showGrants() throws SQLException {
        ResultSet rs = null;
        if(this.connection == null){
            System.out.println("Connection is null, creating new connection");
            this.connection = connect();
        }

        try {
            PreparedStatement statement = this.connection.prepareStatement("SHOW GRANTS FOR ?@?");
            statement.setString(1, username);
            statement.setString(2, "%");
            rs = statement.executeQuery();
            return rs;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;

    }


}
