package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.ResultsSearchLocality;

import java.util.ArrayList;

public interface LocalityPersonInterface {
    ArrayList<ResultsSearchLocality> getPersonLocality(String locality) throws GetDataException, ConnectionException;

}
