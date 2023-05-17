package controllerPackage;

import businessPackage.TypeManager;
import exceptionPackage.*;
import modelPackage.*;


import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicationController {
    private TypeManager manager;

    public ApplicationController()  {
        manager = new TypeManager();
    }

    public ArrayList<ResultsSearchDate> getPersonDate(LocalDate selectedDateStart, LocalDate selectedDateEnd) throws GetDataException, ConnectionException {
        return manager.getPersonDate(selectedDateStart, selectedDateEnd);
    }

    public ArrayList<Person> getAllPerson() throws GetDataException, ConnectionException {
        return manager.getAllPerson();
    }

    public void updatePerson (Person person) throws UpdateDataException, ConnectionException {
        manager.updatePerson(person);
    }

    public void deletePerson(Person person) throws DeleteDataException, ConnectionException {
        manager.deleteType(person);
    }

    public void addPerson(Person person) throws AddDataException, ConnectionException {
        manager.addPerson(person);
    }

    public ArrayList<Locality> getAllLocality() throws GetDataException, ConnectionException {
        return manager.getAllLocality();
    }
    public ArrayList<ResultsSearchLocality> getPersonLocality(String locality) throws GetDataException, ConnectionException {
        return manager.getPersonLocality(locality);
    }

    public ArrayList<Movie> getAllMovie() throws GetDataException, ConnectionException {
        return manager.getAllMovie();
    }
    public ArrayList<Session> getSessionByMovie(String movie) throws GetDataException, ConnectionException {
        return manager.getSessionByMovie(movie);
    }
    public ArrayList<Seat> getFreeSeat(Integer session) throws GetDataException, ConnectionException {
        return manager.getFreeSeat(session);
    }

    public Integer getTotalSeat(Integer session) throws GetDataException, ConnectionException {
        return manager.getTotalSeat(session);
    }
    public Integer getBusySeat (Integer session) throws  GetDataException, ConnectionException {
        return manager.getBusySeat(session);
    }
    public void closeConnection () throws ConnectionException {
        manager.closeConnection();
    }






}
