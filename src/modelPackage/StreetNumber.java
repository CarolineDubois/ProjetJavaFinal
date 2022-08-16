package modelPackage;

import java.util.Objects;

public class StreetNumber {
    private int number;

    public StreetNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    //Test

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        StreetNumber streetNumber = (StreetNumber) o;
        return number == streetNumber.getNumber();
    }
}
