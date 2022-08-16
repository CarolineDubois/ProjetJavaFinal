package testPackage;

import modelPackage.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util. GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
    public class StreetNumberTest {

            private Integer streetNumber1, streetNumber2, streetNumber3, streetNumber4, streetNumber5;

            @BeforeEach
            void setUp() {
                streetNumber1 = new Person(12,"Paul", "Pio", "Rue des poules", 3, new GregorianCalendar(2001,8,03), false,5131321 ).getStreetNumber();
                streetNumber2 = new Person(12,"Paul", "Pio", "Rue des poules", 102, new GregorianCalendar(2001,8,03), false,5131321 ).getStreetNumber();
                streetNumber3 = new Person(12,"Paul", "Pio", "Rue des poules", -1, new GregorianCalendar(2001,8,03), false,5131321 ).getStreetNumber();
                streetNumber4 = new Person(12,"Paul", "Pio", "Rue des poules", 102, new GregorianCalendar(2001,8,03), false,5131321 ).getStreetNumber();
                streetNumber5 = new Person(12,"Paul", "Pio", "Rue des poules", -1, new GregorianCalendar(2001,8,03), false,5131321 ).getStreetNumber();
            }

            @Test
            void testEquals() {
                assertTrue(streetNumber2.equals(streetNumber4));
                assertTrue(streetNumber3.equals(1));
                assertFalse(streetNumber1.equals(streetNumber2));
                assertFalse(streetNumber3.equals(streetNumber5));
            }

}


