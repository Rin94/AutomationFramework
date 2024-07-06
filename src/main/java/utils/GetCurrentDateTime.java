package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentDateTime {

    private GetCurrentDateTime()
    {
    }

    public static String getCurrentTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");

        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    public static String getCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    public static String getCurrentDateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    public static String getCurrentDay()
    {
        String currentDate = getCurrentDate();
        String splitterDate[] = currentDate.split("/");
        String day = splitterDate[2];
        if (day.charAt(0) == '0') {
            day = String.valueOf(day.charAt(1));
        }
        return day;
    }

    public static String getCurrentDateWithDashes()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    public static String getWeekDate(int minusDays)
	{

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate weekDate = LocalDate.now().minusDays(minusDays);

        while (weekDate.getDayOfWeek() == DayOfWeek.SATURDAY || weekDate.getDayOfWeek() == DayOfWeek.SUNDAY)
        {
            weekDate = weekDate.minusDays(minusDays);
        }

        return dateTimeFormatter.format(weekDate);
    }

    public static String getDate(int minusDays)
	{
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(LocalDate.now().minusDays(minusDays));
    }
}
