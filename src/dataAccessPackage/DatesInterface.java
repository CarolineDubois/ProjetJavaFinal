package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.ResultsSearchDate;

import java.time.LocalDate;
import java.util.ArrayList;

public interface DatesInterface {
    ArrayList<ResultsSearchDate> getPersonDate(LocalDate selectedDateStart, LocalDate selectedDateEnd) throws GetDataException, ConnectionException;

}
