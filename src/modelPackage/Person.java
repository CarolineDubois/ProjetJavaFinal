package modelPackage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private Integer identifier;
    private String fistName;
    private String middleName; // falcu
    private String lastName;
    private String street;
    private Integer streetNumber;
    private GregorianCalendar birthDate;
    private boolean isDisabled;
    private Integer phoneNumber; // falcu
    private Integer identifierLocality;

    public Person(Integer identifier, String fistName, String lastName, String middleName, String street, Integer streetNumber,
                  GregorianCalendar birthDate, Integer phoneNumber, boolean isDisabled, Integer identifierLocality) {
        this.identifier = identifier;
        this.fistName = fistName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        setStreetNumber(streetNumber);
        this.birthDate = birthDate;
        this.isDisabled = isDisabled;
        this.phoneNumber = phoneNumber;
        this.identifierLocality = identifierLocality;
    }

    public Person(Integer identifier, String fistName, String lastName, String street, Integer streetNumber,
                  GregorianCalendar birthDate, boolean isDisabled,  Integer identifierLocality) {
        this(identifier, fistName, lastName, null, street, streetNumber, birthDate, null, isDisabled, identifierLocality);
    }

    public void setStreetNumber(Integer streetNumber) {
        if (streetNumber < 0)
            this.streetNumber = 1;
        else
            this.streetNumber = streetNumber;
    }




    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getFistName() {
        return fistName;
    }

    public Integer getIdentifierLocality() {
        return identifierLocality;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getStreet() {
        return street;
    }

    public Boolean getIsDisable(){return isDisabled; }

}
