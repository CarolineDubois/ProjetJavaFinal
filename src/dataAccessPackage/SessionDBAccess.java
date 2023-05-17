package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Session;

import java.sql.*;
import java.util.ArrayList;

public class SessionDBAccess implements SessionInterface{
    public SessionDBAccess(){

    }
    @Override
    public ArrayList<Session> getSessionByMovie(String movie) throws GetDataException, ConnectionException {
        String sqlInstruction = "select * from session where movie = ?";
        ArrayList<Session> sessionList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, movie);


            ResultSet data = preparedStatement.executeQuery();
            Session resultsBySession;

            while (data.next()) {
                resultsBySession = new Session(
                        data.getInt("number"),
                        null,
                        null,
                        data.getString("movie")
                );
                Date date = data.getDate("date");
                if (!data.wasNull()) {
                    resultsBySession.setDate(date.toLocalDate());
                }
                Time time = data.getTime("hourStart");
                if (!data.wasNull()) {
                    resultsBySession.setHourStart(time.toLocalTime());
                }


                sessionList.add(resultsBySession);

            }
            return sessionList;
        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "session");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }
}

