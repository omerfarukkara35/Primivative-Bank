import java.util.Random;
import java.util.Scanner;

class Customer {
    Random rand = new Random();
    Scanner get = new Scanner(System.in);

    int customerID = rand.nextInt(1000000);
    double balance = rand.nextInt(2200);
    double balanceBank = rand.nextInt(2200);

    


    double getBalance() {
        return balance;
    }

    double getBalanceBank() {
        return balanceBank;
    }

    int getCustomerID(){
        return customerID;
    }



}
