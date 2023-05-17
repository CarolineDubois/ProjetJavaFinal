package modelPackage;

public class Seat {
    private Integer identifier;
    private Integer row;
    private Integer number;
    private Integer hall;

    public Seat(Integer identifier, Integer row, Integer number, Integer hall) {
        this.identifier = identifier;
        this.row = row;
        this.number = number;
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Rangée : " + row + " - Numéro : " + number;
    }

}
