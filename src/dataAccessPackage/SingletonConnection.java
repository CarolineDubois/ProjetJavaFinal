package dataAccessPackage;
import java.sql.*;
public class SingletonConnection {
    private static Connection uniqueConnection;
    public static Connection getConnection(){
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false",
                            "root",
                            "Admin123");

        }
        catch(SQLException exception) {
            System.out.println(exception.getMessage());

        }
        return uniqueConnection;
    }

}
