package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Seat;

import java.util.ArrayList;

public interface SeatInterface {
    ArrayList<Seat> getFreeSeat(Integer session) throws GetDataException, ConnectionException;
    int getTotalSeat(Integer session) throws GetDataException, ConnectionException;


}
