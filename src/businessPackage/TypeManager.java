package businessPackage;

import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class TypeManager {

    private DatesInterface datesDao;
    private PersonInterface personDao;
    private LocalityInterface localityDao;
    private LocalityPersonInterface localityPersonDao;
    private MovieInterface movieDao;
    private SessionInterface sessionDao;
    private SeatInterface seatDao;
    private ConnectionInterface connectionDao;



    public TypeManager() {
        datesDao = new DatesPersonAccess();
        localityDao = new LocalityDBAccess();
        personDao = new PersonDBAccess();
        localityPersonDao = new LocalityPersonAccess();
        movieDao = new MovieDBAccess();
        sessionDao = new SessionDBAccess();
        seatDao = new SeatDBAccess();
        connectionDao = new ConnectionDBAccess();

    }

    public ArrayList<ResultsSearchDate> getPersonDate(LocalDate selectedDateStart, LocalDate selectedDateEnd) throws GetDataException, ConnectionException {
        ArrayList<ResultsSearchDate> dateList = datesDao.getPersonDate(selectedDateStart, selectedDateEnd);

        return dateList;
    }
    public ArrayList<ResultsSearchLocality> getPersonLocality(String locality) throws GetDataException, ConnectionException {
        ArrayList<ResultsSearchLocality> localityList = localityPersonDao.getPersonLocality(locality);

        return localityList;
    }

    public ArrayList<Person> getAllPerson() throws GetDataException, ConnectionException {
        ArrayList<Person> personList = personDao.getAllPerson();

        return personList;
    }

    public void updatePerson(Person person) throws UpdateDataException, ConnectionException {
        personDao.updatePerson(person);
    }
    public void deleteType(Person person) throws DeleteDataException, ConnectionException {
        personDao.deletePerson(person);
    }

    public void addPerson(Person person) throws AddDataException, ConnectionException {
        personDao.addPerson(person);
    }

    public ArrayList<Locality> getAllLocality() throws GetDataException, ConnectionException {
        ArrayList<Locality> localityList = localityDao.getAllLocality();

        return localityList;
    }

    public ArrayList<Movie> getAllMovie () throws GetDataException, ConnectionException {
        ArrayList<Movie> movieList = movieDao.getAllMovie();

        return movieList;
    }

    public ArrayList<Session> getSessionByMovie (String movie) throws GetDataException, ConnectionException {
        ArrayList<Session> sessionList = sessionDao.getSessionByMovie(movie);

        return sessionList;
    }

    public ArrayList<Seat> getFreeSeat (Integer session) throws GetDataException, ConnectionException {
        ArrayList<Seat> seatList = seatDao.getFreeSeat(session);

        return seatList;
    }

    public Integer getTotalSeat (Integer session) throws GetDataException, ConnectionException {
        Integer nbSeats = seatDao.getTotalSeat(session);

        return nbSeats;
    }

    public Integer getBusySeat (Integer session) throws GetDataException, ConnectionException{
        Integer nbFreeSeat = getFreeSeat(session).size();
        Integer nbTotalSeat = getTotalSeat(session);

        return nbTotalSeat - nbFreeSeat;
    }

    public void closeConnection () throws ConnectionException {
        connectionDao.closeConnection();
    }



}
