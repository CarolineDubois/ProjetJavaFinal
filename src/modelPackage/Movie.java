package modelPackage;

import java.time.LocalTime;

public class Movie {
    private String title;
    private Integer duration;

    public Movie(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public String toString() {
        return title;
    }
}
