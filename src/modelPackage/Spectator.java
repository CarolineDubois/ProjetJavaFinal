package modelPackage;

import java.util.GregorianCalendar;


public class Spectator extends Person {
    private Integer identifier;
    private String status;

    public Spectator(Integer identifier, String fistName, String middleName, String lastName, String street, Integer streetNumber, GregorianCalendar birthDate, boolean isDisabled, Integer phoneNumber, Integer identifierLocality, Integer identifier1, String status) {
        super(identifier, fistName, middleName, lastName, street, streetNumber, birthDate, phoneNumber, isDisabled, identifierLocality);
        this.identifier = identifier1;
        this.status = status;
    }
}
