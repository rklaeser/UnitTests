import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DateObjTest {
    
        @Test
        public void DateObIsValid(){
            new DateObj(2025, 03, 04);
        }

        @Test
        public void DateObIsNotValid() {
            assertThrows(IllegalArgumentException.class, () -> new DateObj(2025, 13, 32));
    }

    @Test
    public void testValidDates() {
        new DateObj(2025, 3, 4);  // Regular date
        new DateObj(2024, 2, 29); // Leap year
        new DateObj(2023, 12, 31); // End of year
        new DateObj(2023, 11, 30); // Month with 30 days
    }

    @Test
    public void testInvalidDates() {
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2025, 13, 32)); 
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2024, 2, 30));  
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2023, 4, 31));  
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2021, 6, 31));  
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2023, 0, 15));  
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2023, 5, 0));   
    }

    @Test
    public void testLeapYear() {
        new DateObj(2024, 2, 29);  // leap year
        assertThrows(IllegalArgumentException.class, () -> new DateObj(2023, 2, 29)); // NOT leap year
        new DateObj(2000, 2, 29);  // leap year
        assertThrows(IllegalArgumentException.class, () -> new DateObj(1900, 2, 29)); // NOT leap year
    }

    @Test
    public void testNextDateMonthTransition() {
        DateObj endOfMonth = new DateObj(2023, 1, 31);
        assertEquals(new DateObj(2023, 2, 1).toString(), endOfMonth.nextDate().toString());

        DateObj aprilEnd = new DateObj(2023, 4, 30);
        assertEquals(new DateObj(2023, 5, 1).toString(), aprilEnd.nextDate().toString());
    }

    @Test
    public void testNextDateEndOfYear() {
        DateObj endOfYear = new DateObj(2023, 12, 31);
        assertEquals(new DateObj(2024, 1, 1).toString(), endOfYear.nextDate().toString());
    }

    @Test
    public void testNextDateLeapYear() {
        DateObj leapDay = new DateObj(2024, 2, 28);
        assertEquals(new DateObj(2024, 2, 29).toString(), leapDay.nextDate().toString());

        DateObj leapEnd = new DateObj(2024, 2, 29);
        assertEquals(new DateObj(2024, 3, 1).toString(), leapEnd.nextDate().toString());

        DateObj nonLeapEnd = new DateObj(2023, 2, 28);
        assertEquals(new DateObj(2023, 3, 1).toString(), nonLeapEnd.nextDate().toString());
    }
}
