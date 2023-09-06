package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    /**
    NOTE: Change username, password, and port number to use
     */

    private String url = "jdbc:mysql://localhost:8889/Beargrammers";
    private String username = "josh";
    private String password = "Jct!@#123";

    public Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
