public class LeapYear
{
	public static boolean isLeapYear(int date)
	{
		if (date %4 == 0 && date%100 != 0)
			{
			return true;
			}
		if(date % 4 == 0 && date %100 == 0 && date %400 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int leapYearCount(int previousYear)
	{
		int thisYear = DateCall.getYear();
		int counter = 0;
		boolean[] yearArray= new boolean[thisYear - (previousYear+1)];
		//+1 to include the current year
		for(int i = 0;i < yearArray.length;i++)
		{
			yearArray[i] = isLeapYear(previousYear);
			previousYear++;
			if(previousYear > thisYear)
			{
				break;
			}
		}
		for(int i = 0;i < yearArray.length;i++)
		{
			if(yearArray[i]==true) counter++;
		}
		return counter;
	}
	public static void main(String[] args)
	{
		boolean work = true;
		//int[] test= {1925,1984,1923,1975,2000};
		int[]test = {1925};
		/*for(int i=0;i < test.length;i++)
		{
			System.out.println(isLeapYear(test[i]));
		}*/
		//below will be my attempts to get the correct amount of leap years from 
		//the array of dates to the current date.
		
		int thisYear = DateCall.getYear();
		for(int i=0; i < test.length;i++)
		{
			int testYear = thisYear;
			work = true;
			while(work != false)
			{
				System.out.println("TestDate is "+testYear+" is leapyear? "+isLeapYear(testYear));
				testYear--;
				if (testYear == (test[i]-1))
				{
					work = false;
				}
			}
		}
		System.out.println("The total # of leapyears is "+leapYearCount(test[0]));
	}
}