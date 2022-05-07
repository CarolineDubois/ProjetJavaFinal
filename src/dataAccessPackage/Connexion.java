package dataAccessPackage;
import java.sql.*;
public class Connexion {
    public void getConnexion(){
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                            "root",
                            "Admin123");

        }
        catch(SQLException exception) {
            System.out.println(exception.getMessage());

        }
    }

}
