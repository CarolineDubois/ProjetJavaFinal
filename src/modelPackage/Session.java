package modelPackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Session {
    private Integer number;
    private LocalDate date;
    private LocalTime hourStart;
    private String movie;

    public Session(Integer number, LocalDate date, LocalTime hourStart, String movie) {
        this.number = number;
        this.date = date;
        this.hourStart = hourStart;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return date.toString() + " - " + hourStart.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHourStart(LocalTime hourStart) {
        this.hourStart = hourStart;
    }

    public Integer getNumber() {
        return number;
    }
}
