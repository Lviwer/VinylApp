package vinylApp.utils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utils {


    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    public static LocalDate convertToLocalDate (Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public static double convertToDouble(String string) {
        return Double.parseDouble(string);
    }

    public static String cutDoubleToDecimal(double number) {

        return String.format("%.2f", number);
    }


}

//DOUBLE TO STRING