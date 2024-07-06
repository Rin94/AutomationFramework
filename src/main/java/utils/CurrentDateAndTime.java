package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CurrentDateAndTime {
    
	public static String customizeDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public static String getCurrentTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getCurrentDateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

  
    public static LocalDateTime getCurrentDateTimeInLocalDateTimeFormat()
    {
        LocalDateTime now = LocalDateTime.now();
		return now;
    }
    
    
    
}