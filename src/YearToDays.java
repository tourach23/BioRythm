public class YearToDays
{
	public static int monthToDays(int currentMonth,int birthMonth)
	{
		/****************************************************************
		 * from birth month to current month
		 * 
		 * includes all days for birth month but not the current month
		 ***************************************************************/
		int[] dayPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		int monthCounterCheck = 0, totalDaysPerMonth = 0;
		int counter = 0;
		int rollingBirthMonth = birthMonth-1;// we're in base 0 not base 1
		if(birthMonth > currentMonth)
		{
			monthCounterCheck = Math.abs((birthMonth - currentMonth)-12);
		}
		if(birthMonth < currentMonth)
		{
			monthCounterCheck = Math.abs(birthMonth - currentMonth);
		}
		while(counter != monthCounterCheck)
		{
			totalDaysPerMonth += dayPerMonth[rollingBirthMonth];
			rollingBirthMonth++;
			if(rollingBirthMonth > 11)rollingBirthMonth = 0;
			counter++;
		}
		/*
		System.out.println("current age is "+yearDif);
		System.out.println("current months old is "+monthCounterCheck);
		System.out.println("total days old from months is "+totalDaysPerMonth);
		*/
		return totalDaysPerMonth;
	}
	/**************************************************************************
	 * get the total number of days covered from current year to previous year
	 * with regards to whether or not the birthday has passed or not, and add
	 * the appropriate number of days for leapyear.
	 * 
	 * from birthday to birthday * 365 + leapyear
	 *************************************************************************/
	public static int yearToDays(int currentYear, int birthYear,
								int currentMonth,int birthMonth)
	{
		int yearDif = currentYear - birthYear;
		int leapyearcount = 0;
		int totalDays = 0;
		
		if(birthMonth > currentMonth)
		{
			yearDif--;
		}
		leapyearcount = LeapYear.leapYearCount(birthYear);
		totalDays = (yearDif *365)+leapyearcount;
		return totalDays;
	}
	/***********************************************************************
	 * get the number of days that have passed with regard to how many days
	 * are left in the birth month.
	 * 
	 * subtracts out the days up to the birthday in the birth month and adds
	 * how many days are passed in the current month
	 **********************************************************************/
	public static int dayCalc(int birthDay, int currentDay)
	{
		int totaldays = 0;
		totaldays = currentDay - birthDay;
		return totaldays;
	}
	
	public static int dayWork(String birthday)
	{
		int birthDay = DateCall.getDay(birthday);
		int currentDay = DateCall.getDay();
		int currentYear = DateCall.getYear();
		int birthYear = DateCall.getYear(birthday);
		int currentMonth = DateCall.getMonth();
		int birthMonth = DateCall.getMonth(birthday);
		int grandTotal = monthToDays(currentMonth,birthMonth)+
						yearToDays(currentYear,birthYear,
								  currentMonth,birthMonth)+
						dayCalc(birthDay,currentDay);
		return grandTotal;
	}
	
	public static void main(String[] args)
	{
	String birthday = "07,28,1983";
	int birthDay = DateCall.getDay(birthday);
	int currentDay = DateCall.getDay();
	int currentYear = DateCall.getYear();
	int birthYear = DateCall.getYear(birthday);
	int currentMonth = DateCall.getMonth();
	int birthMonth = DateCall.getMonth(birthday);
	int grandTotal = monthToDays(currentMonth,birthMonth)+
					yearToDays(currentYear,birthYear,
							  currentMonth,birthMonth)+
					dayCalc(birthDay,currentDay);
	System.out.println(" combined total is "+grandTotal);
	birthday = "01,01,1920";
	birthDay = DateCall.getDay(birthday);
	birthYear = DateCall.getYear(birthday);
	birthMonth = DateCall.getMonth(birthday);
	grandTotal = monthToDays(currentMonth,birthMonth)+
					yearToDays(currentYear,birthYear,
							  currentMonth,birthMonth)+
					dayCalc(birthDay,currentDay);
	System.out.println(" combined total is "+grandTotal);
	}
}