package dataAccessPackage;

import exceptionPackage.PersonException;
import modelPackage.ResultsSearchDate;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DatesPersonAccess implements  DatesInterface {
    @Override
    public ArrayList<ResultsSearchDate> getPersonDate(GregorianCalendar selectedDate) throws PersonException {
        return null;
    }
}
