package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.Locality;
import modelPackage.ResultsSearchLocality;
import modelPackage.Session;

import java.util.ArrayList;

public interface SessionInterface {
    ArrayList<Session> getSessionByMovie(String movie) throws GetDataException, ConnectionException;

}
