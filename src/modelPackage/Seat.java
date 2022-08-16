package modelPackage;

public class Seat {
    private Integer identifier;
    private Hall hall;
    private Integer row;

    public Seat(Integer identifier, Hall hall, Integer row) {
        this.identifier = identifier;
        this.hall = hall;
        this.row = row;
    }
}
