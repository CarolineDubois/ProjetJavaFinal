package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.ResultsSearchDate;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatesPersonAccess implements  DatesInterface {
    @Override
    public ArrayList<ResultsSearchDate> getPersonDate(LocalDate selectedDateStart, LocalDate selectedDateEnd) throws GetDataException, ConnectionException {
        String sqlInstruction = "SELECT DISTINCT p.*, s.date FROM Person p JOIN Ticket t ON t.spectator = p.identifier JOIN Session s ON s.number = t.session WHERE s.date BETWEEN ? AND ?;";;
        java.sql.Date sqlDateStart = java.sql.Date.valueOf(selectedDateStart);
        java.sql.Date sqlDateEnd = java.sql.Date.valueOf(selectedDateEnd);
        ArrayList<ResultsSearchDate> personList = new ArrayList<>();


        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setDate(1, sqlDateStart);
            preparedStatement.setDate(2, sqlDateEnd);

            ResultSet data = preparedStatement.executeQuery();
            ResultsSearchDate resultsByDate;

            while(data.next()) {
                resultsByDate = new ResultsSearchDate(
                        data.getInt("identifier"),
                        data.getString("firstName"),
                        data.getString("lastName"),
                        null
                );
                Date dateSession = data.getDate("date");
                if(!data.wasNull()){
                    resultsByDate.setDateSession(dateSession.toLocalDate());
                }

                personList.add(resultsByDate);

            }

            return personList;

        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "personne");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }
}



