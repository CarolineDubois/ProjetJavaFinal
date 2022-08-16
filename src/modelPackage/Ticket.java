package modelPackage;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Ticket {
    private Integer identifier;
    private Session session;
    private Seat seat;
    private Receptionist receptionist;
    private double price;
    private Date datePurchase;

    public Ticket(Integer identifier, Session session, Seat seat, Receptionist receptionist, double price, Date datePurchase) {
        this.identifier = identifier;
        this.session = session;
        this.seat = seat;
        this.receptionist = receptionist;
        this.price = price;
        this.datePurchase = datePurchase;
    }
}
