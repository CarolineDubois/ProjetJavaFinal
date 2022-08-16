package dataAccessPackage;

import exceptionPackage.PersonException;
import modelPackage.ResultsSearchDate;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface DatesInterface {
    ArrayList<ResultsSearchDate> getPersonDate(GregorianCalendar selectedDate) throws PersonException;

}
