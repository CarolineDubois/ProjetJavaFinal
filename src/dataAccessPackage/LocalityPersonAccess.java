package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.ResultsSearchLocality;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityPersonAccess implements LocalityPersonInterface {
    @Override
    public ArrayList<ResultsSearchLocality> getPersonLocality(String locality) throws GetDataException, ConnectionException {
        String sqlInstruction = "SELECT p.*, l.label FROM Person p JOIN Locality l ON p.identifierLocality = l.identifier WHERE l.label = ?";
        ArrayList<ResultsSearchLocality> personList = new ArrayList<>();


        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, locality);


            ResultSet data = preparedStatement.executeQuery();
            ResultsSearchLocality resultsByLocality;

            while (data.next()) {
                resultsByLocality = new ResultsSearchLocality(
                        data.getInt("identifier"),
                        data.getString("firstName"),
                        data.getString("lastName"),
                        data.getString("label")
                );

                personList.add(resultsByLocality);

            }

            return personList;

        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "localité");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }
}

