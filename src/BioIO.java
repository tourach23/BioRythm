import java.util.Scanner;
public class BioIO
{
	public static void IO(String s)
	{
		Scanner readIn = new Scanner(s);
		int arrayLength = readIn.nextInt();
		int bioCycle = readIn.nextInt();
		int i = 0;
		String[] birthdays= new String[arrayLength];
		while(readIn.hasNext())
		{
			birthdays[i]=readIn.next();
			i++;
		}
		for(int j = 0;j < birthdays.length;j++)
		{
			double score = Bio.bio(bioCycle,YearToDays.dayWork(birthdays[j]));
			System.out.println(score);
		}

	}
	public static void main(String[] args)
	{
		String s = "4 33 01,01,1920 07,28,1983 01,31,1985 2,22,1979";
		IO(s);
	}
}