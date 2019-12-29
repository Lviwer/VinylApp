package vinylApp.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utils {


public static Date convertToDate(LocalDate localDate){
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
}

//DOUBLE ?
public static double convertToDouble (String string){
    return Double.parseDouble(string);
}





}
