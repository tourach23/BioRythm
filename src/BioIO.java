import java.util.Scanner;
public class BioIO
{
	public static void IO(String s)
	{
		int cycle = 33;
		int counter = 0;
		char[] temp = s.toCharArray();
		for(int i = 0;i<temp.length;i++)
		{
			if(Character.isWhitespace(temp[i]))counter++;
		}
		String t = (counter+1)+" "+cycle+" "+s;
		Scanner readIn = new Scanner(t);
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
		String s = "01,01,1920 07,28,1983 01,31,1985 02,22,1979";
		IO(s);
	}
}