package vinylApp.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utils {


    public static Date convertToDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        } else {
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }


    public static LocalDate convertToLocalDate(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }


}
