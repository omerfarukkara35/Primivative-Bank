import javax.xml.namespace.QName;
import java.util.Random;
import java.util.Scanner;
public class CreditCard{
	//Initialize part
	static void runcreditcard() {
		Random rnd = new Random();
		Scanner scn = new Scanner(System.in);
		boolean run=true;
		int option=0;

		//Main loop statement.
		while(run==true) {
			//Print out the menu.
			System.out.println("Please select an option:");
			System.out.println("");
			System.out.println("1. Check transactions.");
			System.out.println("2. Check for limit.");
			System.out.println("===========================================================================");
			System.out.println("");
			//Check for the user's selection.
			System.out.print("Selection: ");
			option=scn.nextInt();
			//Check for invalid values.
			if (option<1 || option>2) {
				System.err.println("Invalid selection.");
				break;
			}	//First option part.
			if (option==1) {
				//Create array for prices using loop statement.
				int[] transactions = new int [18];
				//Fill the array using loop statement and java math class.
				for(int j = 0; j < transactions.length; j++){
					transactions[j] = (int) (Math.random() * (490)) + 10;
				}
				//Create and fill array for the payments.
				String names[]= {"Turkcell AŞ.", "Izmir University of Economics", "Starbucks", "Media Markt", "McDonalds",
						"ESHOT AŞ.", "Cafe Mio", "Burger King", "Teleferik Çay Bahçesi", "Nobili Park", "Asus",
						"Cafe Alsancak Unlu Mamuller", "TTNET AŞ.", "IZSU AS.", "Altin Kapi Restaurant", "Cesme Tourism",
						"Portakal Büfe", "Pablo Cafe"};

				//Print out the transactions using loop statement.
				for(int i = 0; i<names.length; i++){
					System.out.println(names[i]+ " " + transactions[i] +"$" );
				}
				break;
				//Second option part
			}
			else {
				//Print out the limit predefined limit for user.
				System.out.println("Your limit is: " + 10000 + "$");
				break;
			}
		}

	}
}
