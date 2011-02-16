import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class DateCall
{
	
    public static String getDate() 
	{
        DateFormat dateFormat = new SimpleDateFormat("MM,dd,yyyy");
        Date date = new Date();
        return dateFormat.format(date);
	}
    public static int getYear(String date)
    {
		String delims = "[,]";
		String[] dateSplit = date.split(delims);
		int currentYear = Integer.parseInt(dateSplit[2]);
        return currentYear;
    }
    public static int getMonth(String date)
    {
		String delims = "[,]";
		String[] dateSplit = date.split(delims);
		int currentMonth = Integer.parseInt(dateSplit[0]);
        return currentMonth;
    }
    public static int getDay(String date)
    {
		String delims = "[,]";
		String[] dateSplit = date.split(delims);
		int currentDay = Integer.parseInt(dateSplit[1]);
        return currentDay;
    }
    public static int getYear()
    {
    	String date = getDate();
		String delims = "[,]";
		String[] dateSplit = date.split(delims);
		int currentYear = Integer.parseInt(dateSplit[2]);
        return currentYear;
    }
    public static int getMonth()
    {
    	String date = getDate();
		String delims = "[,]";
		String[] dateSplit = date.split(delims);
		int currentMonth = Integer.parseInt(dateSplit[0]);
        return currentMonth;
    }
    public static int getDay()
    {
    	String date = getDate();
		String delims = "[,]";
		String[] dateSplit = date.split(delims);
		int currentDay = Integer.parseInt(dateSplit[1]);
        return currentDay;
    }
    public static void main(String[] args)
    {
    	String birthday = "07,28,1983";
    	System.out.println("The current date is "+getDate());
    	System.out.println("The current year is "+getYear());
    	System.out.println("The current month is "+getMonth());
    	System.out.println("The current day is "+getDay());
    	System.out.println();
    	System.out.println("The Birthday is "+birthday);
    	System.out.println("The current year is "+getYear(birthday));
    	System.out.println("The current month is "+getMonth(birthday));
    	System.out.println("The current day is "+getDay(birthday));
    }
}