import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    private String accountHoderName;
    private double bankBalance;

    //constructor
    public BankAccount(String accountHoderName, double bankBalance) {
        this.accountHoderName = accountHoderName;
        
        if (bankBalance >= 0 ) {
            this.bankBalance = bankBalance;
        } else {
            System.out.println("Invalid initial balance! Setting it to 0...");
            this.bankBalance = 0;
        }
    }

    //method for amount deposit
    public void deposit(double amount) {
        if (amount > 0) {
            bankBalance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount...");
        }
    }

    //method for withdrawl amount
    public void withdrawl(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawl amount...");
        } else if (amount > bankBalance) {
            System.out.println("Withdrawl rejected. Insufficient balance...");
        } else {
            bankBalance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        }
    }

    
    //getters
    public String getAccountHoderName() {
        return accountHoderName;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = "";
        double initial = 0;

        try {
            //accountHolderName
            System.out.print("Enter your full name: ");
            name = sc.nextLine();

            System.out.print("Enter initial balance: ");
            initial = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric value for balance...");
            initial = 0;
        }

        BankAccount acct = new BankAccount(name, initial);
        int choice = 0;

        do {
            try {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();
                        acct.deposit(deposit);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        acct.withdrawl(withdraw); 
                        break;
                        
                    case 3:
                        System.out.print("Account Holder Name: " + acct.getAccountHoderName());
                        System.out.print("Bank Balance: " + acct.getBankBalance());
                        break;
                        
                    case 4:
                        System.out.print("Thanking you for banking with us!");
                        break;    
                
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter correct data type.");
                sc.next();
            }
        } while (choice != 4);

        sc.close();
    }
}
