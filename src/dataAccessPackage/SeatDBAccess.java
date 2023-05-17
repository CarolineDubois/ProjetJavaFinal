package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Seat;

import java.sql.*;
import java.util.ArrayList;

public class SeatDBAccess implements SeatInterface {
    public SeatDBAccess(){

    }
    @Override
    public ArrayList<Seat> getFreeSeat(Integer session) throws GetDataException, ConnectionException{
        String sqlInstruction = "SELECT * FROM cinema.Seat WHERE identifier NOT IN (SELECT seat FROM cinema.Ticket WHERE session = ?)";
        ArrayList<Seat> seatList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, session);


            ResultSet data = preparedStatement.executeQuery();
            Seat resultsBySeat;

            while (data.next()) {
                resultsBySeat = new Seat(
                        data.getInt("identifier"),
                        data.getInt("row"),
                        data.getInt("number"),
                        data.getInt("hall")
                );

                seatList.add(resultsBySeat);

            }
            return seatList;
        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "siège");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }

    @Override
    public int getTotalSeat(Integer session) throws GetDataException, ConnectionException {
        String sqlInstruction = "SELECT h.nbTotalSeats FROM cinema.Seat s INNER JOIN cinema.Hall h ON s.identifier = h.identifier WHERE s.identifier IN (SELECT seat FROM cinema.Ticket WHERE session = ?);";
        int nbTotalSeats = 0;

        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, session);
            ResultSet data = preparedStatement.executeQuery();

            if(data.next()) {
                nbTotalSeats = data.getInt("nbTotalSeats");
            }

            return nbTotalSeats;

        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "siège");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }
}
