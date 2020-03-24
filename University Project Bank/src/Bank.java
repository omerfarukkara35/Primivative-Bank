import java.util.Random;
import java.util.Scanner;

public class Bank{
    //Test driver.
    public static void main(String[] args) {
    	CreditCard credit = new CreditCard();
    	Invoices inv = new Invoices();
        Random rand = new Random();
        Scanner get = new Scanner(System.in);
        boolean flag = true;
        char option;
        int selection;
        double withdrawMoney, depositMoney;
        Customer customer = new Customer();
        String nameLastName;


        //Until the user gives a valid name, this while will continue to work.
        while(true) {
            //Taking the name of the user.
            System.out.print("Welcome to our bank, please give your name: ");
            nameLastName = get.nextLine();
            //Checking if the user entered an empty name.
            if (nameLastName.equals("")) {
                System.out.println("Please give your name.");
            }else{
                break;
            }
        }

        System.out.println("Welcome "+ nameLastName);
        System.out.println("Your ID is: " + customer.getCustomerID());


        //Until the selection is  7 this while and switch case system will continue to work.
        do{
            while(true) {

                //MENU
                System.out.println("");
                System.out.println("1. Check Balance.");
                System.out.println("2. Withdraw.");
                System.out.println("3. Deposit.");
                System.out.println("4. Check bank balance.");
                System.out.println("5. Invoices.");
                System.out.println("6. Credit Card.");
                System.out.println("7. Exit.");
                System.out.println("===========================================================================");
                System.out.println("");
                System.out.print("Selection: ");
                selection = get.nextInt();
                System.out.println("");

                //Making sure that the user enters a valid menu item, if its not the case then will show the menu again.
                if (selection < 0 || selection >= 8) {
                    System.err.println("Invalid selection, select again please. ");
                }else{
                    break;
                }
                System.out.println("");
            }
            switch(selection){
                case(1):// This case is dedicated to show the user's balance.
                    //Showing the balance of the costumer which has been created randomly previously.
                    System.out.println("Your current balance is: " + customer.getBalance() + "$");
                    break;
                case(2):// This case is dedicated to withdrawing money.
                    //Showing the balance of the costumer which has been created randomly previously.
                    System.out.println("Your current bank balance is : " + customer.getBalanceBank() + "$ ");
                    System.out.println("How much money do you want to withdraw?");
                    withdrawMoney = get.nextDouble();

                    while (flag) {
                        //If the user tries to withdraw money which is greater than the current value in the bank, throw an error.
                        if (customer.getBalanceBank() < withdrawMoney) {
                            System.err.println("Transaction cancelled due to insufficient funds");
                            System.out.println("The money you have in the bank is: " + customer.getBalanceBank() +"$" );
                            //Showing how much money the user has in the bank.
                        } else if (withdrawMoney < 0) {
                            // If the user tries to enter a negative money it breaks the loop and ask for new instructions.
                            System.err.println("Transaction failed due to incorrect amount of money.");
                            break;
                        } else {
                            //Adding and subtracting the corresponding money transactions.
                            System.out.println("Transaction completed.");
                            customer.balance += withdrawMoney;
                            customer.balanceBank -= withdrawMoney;
                            //Showing the current values after the execution of the transactions.
                            System.out.println("Your new balance is: " + customer.getBalance() + "$");
                            System.out.println("Your new bank balance is: " + customer.getBalanceBank() + "$");
                            break;
                        }
                        //Asking the user if further withdraws will occur.
                        System.out.println("Do you want to continue withdrawing? (Y/N)");
                        option = get.next().charAt(0);
                        option = Character.toUpperCase(option);

                        //When the fund is insufficient ask if the user wants to continue withdrawing.
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
                case(3)://This case is dedicated to depositing money.
                    System.out.println("Your current balance is : " + customer.getBalance() + "$ ");
                    System.out.println("How much money do you want to deposit?");
                    depositMoney = get.nextDouble();
                    while (flag) {
                        //If the user wants to deposit money which is greater than the current balance, throw an error.
                        if (customer.getBalance() < depositMoney) {
                            System.err.println("Transaction cancelled due to insufficient funds");
                            System.out.println("The money you have is: " + customer.getBalance() +"$" );
                        }else if (depositMoney < 0) {
                            //If user enters a negative value stop the program and show the menu.
                            System.err.println("Transaction failed due to incorrect amount of money.");
                            break;
                        } else {
                          //Adding and subtracting the corresponding money transactions.
                            System.out.println("Transaction completed.");
                            customer.balance -= depositMoney;
                            customer.balanceBank +=  depositMoney;
                            System.out.println("Your new balance is: " + customer.getBalance() + "$");
                            System.out.println("Your new bank balance is: " + customer.getBalanceBank() + "$");
                            break;
                        }

                        //When the fund is insufficient ask if the user wants to continue depositing.
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
                case(4): // This case is dedicated to show the current bank balance.
                    System.out.println("Your current bank balance is: " + customer.getBalanceBank() + "$");
                    break;
                    
                case (5):
                	Invoices.run();
                break;
                
                case (6):
                	CreditCard.runcreditcard();
                break;
            }
            }while(selection != 7);
        System.out.println("Thanks for using our bank.");
        }
    }