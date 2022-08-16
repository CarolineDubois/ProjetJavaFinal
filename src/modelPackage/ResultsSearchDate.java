package modelPackage;

import java.util.Date;

public class ResultsSearchDate {
    private String identifier;
    private String firstName;
    private String lastName;
    private Date startDate;
    private Date endDate;

    public ResultsSearchDate(String identifier, String firstName, String lastName, Date startDate, Date endDate) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Date getStartDate() {
        return startDate;
    }
}
