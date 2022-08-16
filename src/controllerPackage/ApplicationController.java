package controllerPackage;

import exceptionPackage.PersonException;

import businessPackage.TypeManager;
import exceptionPackage.*;
import modelPackage.*;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ApplicationController {
    private TypeManager manager;

    public ArrayList<ResultsSearchDate> getPersonDate(GregorianCalendar selectedDate) throws PersonException {
        return manager.getPersonDate(selectedDate);
    }

    public ArrayList<Person> getAllPerson() throws AllPersonException, PersonException {
        return manager.getAllPerson();
    }

    public void updatePerson (Person person) throws UpdateException {
        manager.updatePerson(person);
    }

    public void deletePerson(Person person) throws DeleteException {
        manager.deleteType(person);
    }

    public void addPerson(Person person) throws AddPersonException {
        manager.addPerson(person);
    }


}
