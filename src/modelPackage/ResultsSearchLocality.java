package modelPackage;

public class ResultsSearchLocality {
    private Integer identifier;
    private String firstName;
    private String lastName;
    private String locality;

    public ResultsSearchLocality(Integer identifier, String firstName, String lastName, String locality) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.locality = locality;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLocality() {
        return locality;
    }
}
