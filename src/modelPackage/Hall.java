package modelPackage;

public class Hall {
    private Integer identifier;
    private Integer floor;
    private Integer number;
    private Integer nbTotalSeats;

    public Hall(Integer identifier, Integer floor, Integer number, Integer nbTotalSeats) {
        this.identifier = identifier;
        this.floor = floor;
        this.number = number;
        this.nbTotalSeats = nbTotalSeats;
    }
}
