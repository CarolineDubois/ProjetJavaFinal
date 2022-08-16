package dataAccessPackage;
import java.sql.*;
public class SingletonConnexion {
    public void getConnexion(){
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false",
                            "root",
                            "Admin123");

        }
        catch(SQLException exception) {
            System.out.println(exception.getMessage());

        }

    }

}
