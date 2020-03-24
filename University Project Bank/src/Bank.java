import java.util.Random;
import java.util.Scanner;

public class Bank{
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner get = new Scanner(System.in);
        boolean flag = true;
        char option;
        int selection;
        double withdrawMoney, depositMoney;
        Customer customer = new Customer();

        System.out.print("Welcome to our bank, please give your name: ");
        String nameLastName = get.nextLine();


        System.out.println("Welcome "+ nameLastName);
        System.out.println("Your ID is: " + customer.getCustomerID());

        do{
            while(true) {
                System.out.println("");
                System.out.println("1. Check Balance.");
                System.out.println("2. Withdraw.");
                System.out.println("3. Deposit");
                System.out.println("4. Check bank balance.");
                System.out.println("5. Exit.");
                System.out.println("===========================================================================");
                System.out.println("");
                System.out.print("Selection: ");
                selection = get.nextInt();
                System.out.println("");
                if (selection < 0 || selection >= 6) {
                    System.err.println("Invalid selection, select again please. ");
                }else{
                    break;
                }
                System.out.println("");
            }
            switch(selection){
                case(1):
                    System.out.println("Your current balance is: " + customer.getBalance() + "$");
                    break;
                case(2):
                    System.out.println("Your current bank balance is : " + customer.getBalanceBank() + "$ ");
                    System.out.println("How much money do you want to withdraw?");
                    withdrawMoney = get.nextDouble();
                    while (flag) {
                        if (customer.getBalanceBank() < withdrawMoney) {
                            System.err.println("Transaction cancelled due to insufficient funds");
                            System.out.println("The money you have in the bank is: " + customer.getBalanceBank() +"$" );
                        } else if (customer.getBalanceBank() < 0) {
                            System.err.println("Transaction failed due to incorrect amount of money.");
                        } else {
                            System.out.println("Transaction completed.");
                            customer.balance += withdrawMoney;
                            customer.balanceBank -= withdrawMoney;
                            System.out.println("Your new balance is: " + customer.getBalance() + "$");
                            System.out.println("Your new bank balance is: " + customer.getBalanceBank() + "$");
                            break;
                        }
                        System.out.println("Do you want to continue withdrawing? (Y/N)");
                        option = get.next().charAt(0);
                        option = Character.toUpperCase(option);

                        switch (option){
                            case 'Y':
                                System.out.println("New amount of money: ");
                                withdrawMoney = get.nextDouble();
                                break;
                            case 'N':
                                flag = false;
                                break;
                        }
                    }
                    System.out.println("Transaction segment is closed.");

                    break;
                case(3):
                    System.out.println("Your current balance is : " + customer.getBalance() + "$ ");
                    System.out.println("How much money do you want to deposit?");
                    depositMoney = get.nextDouble();
                    while (flag) {
                        if (customer.getBalance() < depositMoney) {
                            System.err.println("Transaction cancelled due to insufficient funds");
                            System.out.println("The money you have is: " + customer.getBalance() +"$" );
                        }else if (depositMoney < 0) {
                            System.err.println("Transaction failed due to incorrect amount of money.");
                        } else {
                            System.out.println("Transaction completed.");
                            customer.balance -= depositMoney;
                            customer.balanceBank +=  depositMoney;
                            System.out.println("Your new balance is: " + customer.getBalance() + "$");
                            System.out.println("Your new bank balance is: " + customer.getBalanceBank() + "$");
                            break;
                        }
                        System.out.println("Do you want to continue withdrawing? (Y/N)");
                        option = get.next().charAt(0);
                        option = Character.toUpperCase(option);

                        switch (option){
                            case 'Y':
                                System.out.println("New amount of money: ");
                                depositMoney = get.nextDouble();
                                break;
                            case 'N':
                                flag = false;
                                break;
                        }
                    }
                    System.out.println("Transaction segment is closed.");
                    break;
                case(4):
                    System.out.println("Your current bank balance is: " + customer.getBalanceBank() + "$");
                    break;
            }
            }while(selection != 5);
        System.out.println("Thanks for using our bank.");
        }
    }