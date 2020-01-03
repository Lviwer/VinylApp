package vinylApp.utils;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import javax.script.Bindings;
import java.awt.*;
import java.text.DecimalFormat;
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


    public static double convertToDouble(String string) {
        return Double.parseDouble(string);
    }

    public static String cutDoubleToDecimal(double number) {

        return String.format("%.2f", number);
    }


  // public static double textFieldToDouble(TextField textField){
  //          DecimalFormat decimalFormat = new DecimalFormat("%,##");
  //          try
  //          {
  //              return textField.p
  //          }
//
  // }



}
