package Calendar;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;


public class Calendar {
    private final Set<MonthDay> holidays = new HashSet<>();

    Days customHolidays;

    public Calendar() {
        this.customHolidays = new Days();
    }

    public ArrayList<LocalDate> getWeekendsInDiapason(LocalDate start, LocalDate end){
        ArrayList<LocalDate> weekends = new ArrayList<>();
        for (LocalDate i = start; !i.isAfter(end); i = i.plusDays(1)) {
            if (customHolidays.isWeekend(i)) {
                weekends.add(i);
            }
        }
        return weekends;
    }

    public ArrayList<LocalDate> getHolidaysInDiapason(LocalDate start, LocalDate end){
        ArrayList<LocalDate> holidaysList = new ArrayList<>();
        for (LocalDate i = start; !i.isAfter(end); i = i.plusDays(1)) {
            if (customHolidays.isHoliday(i)) {
                holidaysList.add(i);
            }
        }
        return holidaysList;
    }

    public ArrayList<LocalDate> getWeekendsAndHolidaysInDiapason(LocalDate start, LocalDate end){
        ArrayList<LocalDate> weekendsAndHolidays = new ArrayList<>();
        for (LocalDate i = start; !i.isAfter(end); i = i.plusDays(1)) {
            if (customHolidays.isHoliday(i) || customHolidays.isWeekend(i)) {
                weekendsAndHolidays.add(i);
            }
        }
        return weekendsAndHolidays;
    }




    public void addHoliday(MonthDay monthDay) {
        holidays.add(monthDay);
    }

    public Set<MonthDay> getHolidays(){
        return holidays;
    }

    private class  Days{
        public boolean isHoliday(LocalDate date){
            return  holidays.contains(toMonthDay(date));

        }

        public boolean isWeekend(LocalDate date){
            DayOfWeek weekDay = date.getDayOfWeek();
            return weekDay == DayOfWeek.SATURDAY || weekDay == DayOfWeek.SUNDAY;
        }

        public  MonthDay toMonthDay(LocalDate localDate) {
            return MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        }

    }
}
