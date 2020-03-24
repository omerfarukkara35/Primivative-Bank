import java.util.Random;
import java.util.Scanner;

public class Customer {
    Random rand = new Random();
    Scanner get = new Scanner(System.in);

    int customerID = rand.nextInt(1000000);
    double balance = rand.nextInt(2200);
    double balanceBank = rand.nextInt(2200);



    public double getBalance() {
        return balance;
    }

    public double getBalanceBank() {
        return balanceBank;
    }

    public int getCustomerID(){
        return customerID;
    }

}
