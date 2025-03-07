
public class DateObj {
	
	private int year;
	private int month;
	private int day;
	private static int[] monthLengths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public DateObj(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		validate();
	}

	public DateObj nextDate() {
        int newYear = year; 
        int newMonth = month; 
        int newDay = day + 1;
        int daysInMonth = getDaysInMonth(month, year);

        // Go to next month
        if (newDay > daysInMonth) {
            newDay = 1; // Back to first day of the month
            newMonth++;

            // Happy New Year!
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }

        return new DateObj(newYear, newMonth, newDay);
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }
        return false;
    }
    
    private static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            }
        }
        return monthLengths[month - 1];
    }

	@Override
	public String toString() {
		return String.format("Date[year: %d, month: %d, day: %d]", year, month, day);
	}

	void validate() {
        if (month < 1 || month > 12 || day < 1) {
            throw new IllegalArgumentException("Invalid date");
        }
    
        int maxDays = getDaysInMonth(month, year);
    
        if (day > maxDays) {
            throw new IllegalArgumentException("Invalid date: day out of range for the given month and year");
        }
    }
}
