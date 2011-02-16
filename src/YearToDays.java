public class YearToDays
{
	public static int monthToDays(String birthday)
	{
		int currentMonth = DateCall.getMonth();
		int birthMonth = DateCall.getMonth(birthday);
		int[] dayPerMonth = {31,28,31,30,31,30,31,30,31,30,31,30};
		int monthCounterCheck = 0, totalDaysPerMonth = 0;
		int counter = 0;
		int rollingBirthMonth = birthMonth-1;// we're in base 0 not base 1
		/****************************************************************
		 * get the number of days passed since last birthday
		 * without worrying about years or days
		 ***************************************************************/
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
	 *************************************************************************/
	public static int yearToDays(String birthday)
	{
		int currentYear = DateCall.getYear();
		int birthYear = DateCall.getYear(birthday);
		int currentMonth = DateCall.getMonth();
		int birthMonth = DateCall.getMonth(birthday);
		int yearDif = currentYear - birthYear;
		int leapyearcount = 0;
		int totalDays = 0;
		
		if(birthMonth > currentMonth)
		{
			yearDif--;
		}
		leapyearcount = LeapYear.leapYearCount(birthYear);
		totalDays = (yearDif *364)+leapyearcount;
		return totalDays;
	}
	/***********************************************************************
	 * get the number of days that have passed with regard to how many days
	 * are left in the birth month.
	 **********************************************************************/
	public static int dayCalc(String birthday)
	{
		int birthDay = DateCall.getDay(birthday);
		int birthMonth = DateCall.getMonth(birthday);
		int[] dayPerMonth = {31,28,31,30,31,30,31,30,31,30,31,30};
		int baseBirthMonth = birthMonth-1;// we're in base 0 not base 1
		int totaldays = 0;
		totaldays = dayPerMonth[baseBirthMonth] - birthDay;
		return totaldays;
	}
	
	
	public static void main(String[] args)
	{
	String birthday = "07,28,1983";
	String birthday1 = "01,01,1920";
	int monthtodays = monthToDays(birthday);
	int yeartodays = yearToDays(birthday);
	int birthmonth = dayCalc(birthday);
	int monthsdays = DateCall.getDay(birthday);
	int grandtotal = monthtodays + yeartodays+ birthmonth+monthsdays;
	System.out.println("total months to days is "+monthtodays+" total year to days is "+yeartodays+" total days left in birth month is "+birthmonth+" total days passed in this month is "+monthsdays+" combined total is "+grandtotal);
	monthtodays= monthToDays(birthday1);
	yeartodays = yearToDays(birthday1);
	birthmonth = dayCalc(birthday1);
	monthsdays = DateCall.getDay(birthday1);
	grandtotal = monthtodays + yeartodays+ birthmonth+monthsdays;
	System.out.println("total months to days is "+monthtodays+" total year to days is "+yeartodays+" total days left in birth month is "+birthmonth+" total days passed in this month is "+monthsdays+" combined total is "+grandtotal);
	}
}