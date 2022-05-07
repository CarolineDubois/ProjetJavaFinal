package modelPackage;

import java.time.LocalTime;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Session {
    private Integer number;
    private Date date;
    private LocalTime hourStart;
    private Movie movie;

    public Session(Integer number, Date date, LocalTime hourStart, Movie movie) {
        this.number = number;
        this.date = date;
        this.hourStart = hourStart;
        this.movie = movie;
    }
}
