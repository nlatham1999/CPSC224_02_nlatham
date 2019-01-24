import java.util.Scanner;

public class Conversion
{
	public static void main(String[] args)
	{
		boolean isGoing = true;
		Scanner keyboard = new Scanner(System.in);
		int meters;
		
		while(isGoing){
			System.out.println("Enter a distance in meters");
			meters = keyboard.nextInt();
			System.out.println("What type of conversion  do you want");	
			System.out.println("1: convert to kilometers");
			System.out.println("2 convert to inches");
			System.out.println("3 convert to feet");
			System.out.println("4 quit");
			
			switch(meters){
				case 1:
					break;
				case 2:
					break;
				case
					break;
				default:
					break;
			}
		}
	}
}