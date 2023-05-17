package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;
import java.util.ArrayList;

public interface PersonInterface {
    void addPerson(Person person) throws AddDataException, ConnectionException;

    ArrayList<Person> getAllPerson() throws GetDataException, ConnectionException;

    void updatePerson(Person person) throws UpdateDataException, ConnectionException;

    void deletePerson(Person person) throws DeleteDataException, ConnectionException;
}
