import java.util.Scanner;

public class ICA1
{
	public static void main(String[] args)
	{
		boolean isGoing = true;
		Scanner keyboard = new Scanner(System.in);
		int meters = 0;
		int choice = 0;
		
		System.out.println("Enter a distance in meters");
		
		boolean correctInput = false;
		while(!correctInput){
			meters = keyboard.nextInt();
			if(meters < 0){
				System.out.println("NEGATIVES NOT ALLOWED");
			}else{
				correctInput = true;
			}
		}
		
		while(isGoing){
			
			displayMenu();

			correctInput = false;
			while(!correctInput){
				choice = keyboard.nextInt();
				if(choice > 4 || choice < 1){
					System.out.println("THAT IS NOT A CHOICE!!!");
				}else{
					correctInput = true;
				}
			}
				
			
			switch(choice){
				case 1:
					System.out.println(meters + " meters is " + showKilometers(meters) + " kilometers");
					break;
				case 2:
					System.out.println(meters + " meters is " + showInches(meters) + " inches");
					break;
				case 3:
					System.out.println(meters + " meters is " + showFeet(meters) + " feet");
					break;
				default:
					System.out.println("bye");
					isGoing = false;
					break;
			}
		}
	}
	
	public static double showKilometers(double x){
		return x*.001;
	}
	
	public static double showInches(double x){
		return x*39.37;
	}
	
	public static double showFeet(double x){
		return x*3.281;
	}
	
	public static void displayMenu(){
		System.out.println("What type of conversion  do you want");	
		System.out.println("1: convert to kilometers");
		System.out.println("2 convert to inches");
		System.out.println("3 convert to feet");
		System.out.println("4 quit");
	}		
}