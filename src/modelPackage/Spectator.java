package modelPackage;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Spectator extends Person {
    private Integer identifier;
    private String status;

    public Spectator(Integer identifier, String fistName, String middleName, String lastName, String street, Integer streetNumber, Date birthDate, boolean isDisabled, Integer phoneNumber, String identifierLocality, Integer identifier1, String status) {
        super(identifier, fistName, middleName, lastName, street, streetNumber, birthDate, isDisabled, phoneNumber, identifierLocality);
        this.identifier = identifier1;
        this.status = status;
    }
}
