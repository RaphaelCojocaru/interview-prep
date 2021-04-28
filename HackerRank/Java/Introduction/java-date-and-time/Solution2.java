import java.time.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-date-and-time/problem
public static String findDay(int month, int day, int year) {
    String input_date = (day + "/" + month + "/" + year), dayOfTheWeek = null;
    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

    try {
        Date dt1 = format1.parse(input_date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        dayOfTheWeek = format2.format(dt1).toUpperCase();
    } catch (Exception e) {}

    return dayOfTheWeek;
}