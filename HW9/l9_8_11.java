import Calendar.Calendar;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

public class l9_8_11 {
    public static void main(String[] args){
        Calendar calendar = new Calendar();
        calendar.addHoliday(MonthDay.of(Month.OCTOBER, 14));
        calendar.addHoliday(MonthDay.of(Month.OCTOBER, 19));
        calendar.addHoliday(MonthDay.of(Month.DECEMBER, 31));
        System.out.println("Weekends: " + calendar.getWeekendsInDiapason(LocalDate.of(2022, 10, 1),
                LocalDate.of(2023, 1, 1)));
        System.out.println("Holidays: " + calendar.getHolidaysInDiapason(LocalDate.of(2022, 10, 1),
                LocalDate.of(2023, 1, 1)));
        System.out.println("Weekends and Holidays: " + calendar.getWeekendsAndHolidaysInDiapason(LocalDate.of(2022, 10, 1),
                LocalDate.of(2023, 1, 1)));
    }
}
