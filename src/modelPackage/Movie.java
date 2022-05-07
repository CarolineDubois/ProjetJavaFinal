package modelPackage;

import java.time.LocalTime;

public class Movie {
    private String title;
    private LocalTime duration;

    public Movie(String title, LocalTime duration) {
        this.title = title;
        this.duration = duration;
    }
}
