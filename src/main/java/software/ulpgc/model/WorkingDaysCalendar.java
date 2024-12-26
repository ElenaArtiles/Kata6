package software.ulpgc.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class WorkingDaysCalendar {
    public Iterator<LocalDate> iteratorFor(LocalDate date) {
        return new Iterator<>() {
            LocalDate current = date;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                var next = current.plusDays(1);
                while (!isWorkingDay(next)) next = next.plusDays(1);
                current = next;
                return next;
            }

            private boolean isWorkingDay(LocalDate date) {
                return workingDays.contains(date.getDayOfWeek());
            }


        };
    }
    private final Set<DayOfWeek> workingDays = Set.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);
}
