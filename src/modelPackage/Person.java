package modelPackage;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Person {
    private Integer identifier;
    private String fistName;
    private String middleName; // falcu
    private String lastName;
    private String street;
    private Integer streetNumber;
    private Date birthDate;
    private boolean isDisabled;
    private Integer phoneNumber; // falcu
    private String identifierLocality;

    public Person(Integer identifier, String fistName, String middleName, String lastName, String street, Integer streetNumber,
                  Date birthDate, boolean isDisabled, Integer phoneNumber, String identifierLocality) {
        this.identifier = identifier;
        this.fistName = fistName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.birthDate = birthDate;
        this.isDisabled = isDisabled;
        this.phoneNumber = phoneNumber;
        this.identifierLocality = identifierLocality;
    }


}
