package modelPackage;

import java.time.LocalDate;
import java.util.Date;

public class ResultsSearchDate {
    private Integer identifier;
    private String firstName;
    private String lastName;
    private LocalDate dateSession;

    public ResultsSearchDate(Integer identifier, String firstName, String lastName, LocalDate dateSession) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateSession = dateSession;
    }

    public void setDateSession(LocalDate dateSession) {
        this.dateSession = dateSession;
    }

    public String getLastName() {
        return lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public LocalDate getDateSession() {
        return dateSession;
    }
}
