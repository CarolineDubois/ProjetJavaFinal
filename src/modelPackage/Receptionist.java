package modelPackage;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.Locale;

public class Receptionist extends Person {
    private Integer identifier;
    private GregorianCalendar startContract;
    private GregorianCalendar endContract; // falcu

    public Receptionist(Integer identifier, String fistName, String middleName, String lastName, String street, Integer streetNumber, GregorianCalendar birthDate, boolean isDisabled, Integer phoneNumber, Integer identifierLocality, int identifier1, GregorianCalendar startContract, GregorianCalendar endContract) {
        super(identifier, fistName, middleName, lastName, street, streetNumber, birthDate, phoneNumber, isDisabled, identifierLocality);
        this.identifier = identifier1;
        this.startContract = startContract;
        this.endContract = endContract;
    }
}
