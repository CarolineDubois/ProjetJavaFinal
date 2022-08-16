package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;
import java.util.ArrayList;

public interface PersonDataAccess {
    void addPerson(Person person) throws AddPersonException;

    ArrayList<Person> getAllPerson() throws AllPersonException;

    void updatePerson(Person person) throws UpdateException;

    void deletePerson(Person person) throws DeleteException;
}
