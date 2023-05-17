package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Locality;
import java.util.ArrayList;

public interface LocalityInterface {
    ArrayList<Locality> getAllLocality() throws GetDataException, ConnectionException;

}
