/*************************************************************************
 * Program designed given an input of cycles and date in the format
 * mm,dd,yyyy, will provide the percentage of biorythm for the given cycles.
 * 
 * to compile: javac Bio.java
 * example to run: java Bio 33 07,28,1983 
 * 
 * days old conversion is not 100%, when tested with the day "01,01,1920"
 * the days old calculation was off by 1.5 days.  when tested with the date
 * "01,31,1985" the date was off by .5 days.  
 * 
 * Not perfect but with my current knowledge without consulting further 
 * resources(highly experienced programmers) this is as close as i am 
 * currently able to get.
 * 
 *************************************************************************/


public class Bio
{
		
	/***********************************************************
	 *	Biorythm calculations
	 **********************************************************/
	public static double bio(int cycle, double age)
	{
		double score = 100 * Math.sin ( 2*Math.PI*(180/Math.PI) *(age / cycle));
		return score;
	}
	
	public static void main(String[] args)
	{//command line input requires cycle length, then age in days separated by a space
		int cycle = Integer.parseInt(args[0]);
		int daysOld = YearToDays.dayWork(args[1]);
		System.out.println(daysOld);
		double score = bio(cycle,daysOld);
		System.out.println(score);
		
	}

}