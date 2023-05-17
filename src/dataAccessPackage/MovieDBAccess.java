package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDBAccess  implements MovieInterface{
    public MovieDBAccess()   {

    }
    @Override
    public ArrayList<Movie> getAllMovie() throws GetDataException, ConnectionException {
        String sqlInstruction = "select * from movie";
        ArrayList<Movie> allMovie = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =  SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            Movie movie;

            while (data.next()) {
                movie = new Movie(
                        data.getString("title"),
                        data.getInt("duration")
                );

                allMovie.add(movie);
            }

            return allMovie;
        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "personne");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }


    }

}
