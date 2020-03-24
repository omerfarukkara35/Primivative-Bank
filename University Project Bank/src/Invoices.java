import java.util.Random;
import java.util.Scanner;
class Invoices {
	//Initialize part.
	static void run() {
		boolean run = true;
		int type=0;
		int year=0;
		int month=0;
		Random rnd = new Random();
		Scanner scn = new Scanner(System.in);
		//Create and fill array for months.
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		//Create and fill array for years.
		int[] years = {2019, 2018, 2017, 2016, 2015};
		//Filling up the telephone bill with random variables.
		int [] telephone= new int[12];   
		for(int i = 0; i<telephone.length; i++){
			telephone[i]=rnd.nextInt(100);
		}
		// Filling up the telephone bill with random variables.
		int[] electricity = new int[12]; 
		for(int i = 0; i<electricity.length; i++){
			electricity[i]=rnd.nextInt(200);
		}
		//Main loop statement.
		while(true) {
			//Display menu.
			System.out.println("Please select invoice type:");
			System.out.println("1--->Telephone, 2 --->Electricity");
			System.out.println("To list all of your invoices please enter 0");
			type=scn.nextInt();
			//Check user's option.
			if (type==0) {
				System.out.println("Please select year:");
				System.out.println("1--->2019, 2 --->2018, 3 --->2017, 4 --->2016, 5 --->2015");
				year=scn.nextInt();
				if (year<1 || year>5) {
					//Check for invalid option.
					System.err.println("Invalid selection, do the process again please.");
					run = false;
					break;}
				int count3=0;
				//Loop statement for printing all invoices.
				while (count3<12) {

					System.out.println("Telephone   Invoice for "+ years[year] + " " + months[month] + " is " + telephone[month]+ "$"  );
					System.out.println("Electricity Invoice for "+ years[year]+ " " + months[month] + " is " + electricity[month]+"$"  );
					month++;
					count3++;
				}
				break;
			}
			if (type<0 || type>2) {
				//Check for invalid option.
				System.err.println("Invalid selection.");
				run=false;
				break;
			}

			System.out.println("Please select year:");
			System.out.println("1--->2019, 2 --->2018, 3 --->2017, 4 --->2016, 5 --->2015");
			//Check for user's option.
			year=scn.nextInt();
			if (year<1 || year>5) {
				//Check for invalid option.
				System.err.println("Invalid selection.");
				run=false;
				break;
			}
			System.out.println("Please select month:");
			System.out.println("Enter a number of a month (Ex:12 for december)");
			month=scn.nextInt();
			//Check for user's option.
			if (month<1 || month>12) {
				//Check for invalid option.
				System.err.println("Invalid selection.");
				run=false;
				break;
			}
			month--;
			//Deciding and printing out the invoice type of the user's choice.
			if(type==1) System.out.println("Telephone Invoice for "+ years[year] + " " + months[month] + " is " + telephone[month]+"$" );
			if(type==2) System.out.println("Electricity Invoice for "+ years[year]+ " " + months[month] + " is " + electricity[month]+"$" );

			break;

		}
	}
}



