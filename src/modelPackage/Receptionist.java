package modelPackage;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Receptionist extends Person {
    private Integer identifier;
    private Date startContract;
    private Date endContract; // falcu

    public Receptionist(Integer identifier, String fistName, String middleName, String lastName, String street, Integer streetNumber, Date birthDate, boolean isDisabled, Integer phoneNumber, String identifierLocality, int identifier1, Date startContract, Date endContract) {
        super(identifier, fistName, middleName, lastName, street, streetNumber, birthDate, isDisabled, phoneNumber, identifierLocality);
        this.identifier = identifier1;
        this.startContract = startContract;
        this.endContract = endContract;
    }
}
