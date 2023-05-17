package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Locality;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityDBAccess implements LocalityInterface {

    public LocalityDBAccess()   {

    }
    @Override
    public ArrayList<Locality> getAllLocality() throws GetDataException, ConnectionException {
        String sqlInstruction = "select * from locality";
        ArrayList<Locality> allLocality = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =  SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            Locality locality;

            while (data.next()) {
                locality = new Locality(
                        data.getInt("identifier"),
                        data.getString("label"),
                        data.getInt("postalCode")
                );

                allLocality.add(locality);
            }

            return allLocality;
        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "localité");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }


    }
}
