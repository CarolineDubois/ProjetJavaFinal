package modelPackage;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private Integer identifier;
    private String fistName;
    private String middleName;
    private String lastName;
    private String street;
    private Integer streetNumber;
    private LocalDate birthDate;
    private boolean isDisabled;
    private String phoneNumber;
    private Integer identifierLocality;

    public Person(Integer identifier, String fistName, String lastName, String middleName, String street, Integer streetNumber,
                  LocalDate birthDate, String phoneNumber, boolean isDisabled, Integer identifierLocality) {
        this.identifier = identifier;
        this.fistName = fistName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        setStreetNumber(streetNumber);
        setBirthDate(birthDate);
        this.isDisabled = isDisabled;
        this.phoneNumber = phoneNumber;
        this.identifierLocality = identifierLocality;
    }

    public Person(String fistName, String middleName, String lastName, String street, Integer streetNumber, LocalDate birthDate, boolean isDisabled, String phoneNumber, Integer identifierLocality) {
        this(null, fistName, lastName, middleName, street, streetNumber, birthDate, phoneNumber, isDisabled, identifierLocality);

    }

    public Person(Integer identifier, String fistName, String middleName, String lastName, String street, Integer streetNumber, LocalDate birthDate, boolean isDisabled, String phoneNumber, Integer identifierLocality) {
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

    public void setStreetNumber(Integer streetNumber) {
        if (streetNumber < 0)
            this.streetNumber = 1;
        else
            this.streetNumber = streetNumber;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getPhoneNumber() {
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

    public Boolean getIsDisable() {
        return isDisabled;
    }

    @Override
    public String toString() {
        return "Person{" +
                "identifier=" + identifier +
                ", fistName='" + fistName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", birthDate=" + birthDate +
                ", isDisabled=" + isDisabled +
                ", phoneNumber=" + phoneNumber +
                ", identifierLocality=" + identifierLocality +
                '}';
    }
}
