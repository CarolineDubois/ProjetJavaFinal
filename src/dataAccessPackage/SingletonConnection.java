package dataAccessPackage;
import exceptionPackage.ConnectionException;

import java.sql.*;
public class SingletonConnection {
    private static Connection uniqueConnection;


    public static Connection getConnection() throws ConnectionException {
        if(uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema",
                        "root",
                        "Admin123");

            } catch(SQLException exception) {
                throw new ConnectionException(exception.getMessage());
            }

        }
        return uniqueConnection;
    }

}


