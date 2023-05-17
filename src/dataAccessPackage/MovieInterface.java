package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Movie;

import java.util.ArrayList;

public interface MovieInterface {
    ArrayList<Movie> getAllMovie() throws GetDataException, ConnectionException;

}
