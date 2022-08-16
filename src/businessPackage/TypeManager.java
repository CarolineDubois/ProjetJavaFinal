package businessPackage;

import dataAccessPackage.DatesPersonAccess;
import dataAccessPackage.PersonDBAccess;
import dataAccessPackage.PersonDataAccess;
import exceptionPackage.*;
import modelPackage.Person;
import modelPackage.ResultsSearchDate;
import viewPackage.ResultsPanel;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TypeManager {

    private PersonDBAccess dao;
    private DatesPersonAccess datesDao;
    private PersonDataAccess personDao;


    public TypeManager() throws ConnectionException {
        dao = new PersonDBAccess();
        datesDao = new DatesPersonAccess();

    }

    public ArrayList<ResultsSearchDate> getPersonDate(GregorianCalendar selectedDate) throws PersonException {
        ArrayList<ResultsSearchDate> articlesList = datesDao.getPersonDate(selectedDate);

        return articlesList;
    }

    public ArrayList<Person> getAllPerson() throws PersonException, AllPersonException {
        ArrayList<Person> personList = personDao.getAllPerson();

        return personList;
    }

    public void updatePerson(Person person) throws UpdateException {
        dao.updatePerson(person);
    }
    public void deleteType(Person person) throws DeleteException {
        dao.deletePerson(person);
    }

    public void addPerson(Person person) throws AddPersonException {
        dao.addPerson(person);
    }

}
