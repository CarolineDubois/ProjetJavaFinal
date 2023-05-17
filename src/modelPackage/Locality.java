package modelPackage;

public class Locality {
    private Integer identifier;
    private String label;
    private Integer postalCode;

    public Locality(Integer identifier, String label, Integer postalCode) {
        this.identifier = identifier;
        this.label = label;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return label + " - " + postalCode;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getLabel() {
        return label;
    }
}
