import java.util.*;
import java.text.*;

// Account class manages balances and basic banking operations
class Account {
    Scanner sc = new Scanner(System.in);

    // DecimalFormat objects for displaying balances in currency format
    DecimalFormat df1 = new DecimalFormat("##,###0.00' Rupee'");
    DecimalFormat df2 = new DecimalFormat("##,###0.00' Rupee'");

    // Private member variables for customer and PIN numbers
    private int cn;
    private int pn;

    // Default balances for current and saving accounts
    double CB = 2000;
    double SB = 1000;

    // Setter for customer number
    void setCustomerNumber(int cn) {
        this.cn = cn;
    }

    // Setter for PIN number
    void setPINNumber(int pn) {
        this.pn = pn;
    }

    // Getter for customer number
    int getCustomerNumber() {
        return cn;
    }

    // Getter for PIN number
    int getPINNumber() {
        return pn;
    }

    // Display current account balance
    void getCurrentBalance() {
        System.out.println("Current Balance : " + df1.format(CB));
    }

    // Display saving account balance
    void getSavingBalance() {
        System.out.println("Saving Balance : " + df1.format(SB));
    }

    // Handle current account withdrawal input and check balance
    void getCurrentWithdrawInput() {
        System.out.println("Current Balance : " + df1.format(CB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if ((CB - amount) >= 0) {
            calcCurrentWithdraw(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Current Balance : " + df1.format(CB));
        } else {
            System.out.println("\n Insufficient Balance");
        }
    }

    // Logic to subtract withdrawal amount from current balance
    double calcCurrentWithdraw(double amount) {
        CB = CB - amount;
        return CB;
    }

    // Handle saving account withdrawal input and check balance
    void getSavingWithdrawInput() {
        System.out.println("Current Balance : " + df2.format(SB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if ((SB - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Saving Balance : " + df2.format(SB));
        } else {
            System.out.println("\n Insufficient Balance");
        }
    }

    // Logic to subtract withdrawal amount from saving balance
    double calcSavingWithdraw(double amount) {
        SB = SB - amount;
        return SB;
    }

    // Handle deposit input to current account
    void getCurrentDeposit() {
        System.out.println("Current Balance : " + df1.format(CB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if ((CB + amount) >= 0) {
            calcCurrentDeposit(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Current Balance : " + df1.format(CB));
        } else {
            System.out.println("\n Invalid Money");
        }
    }

    // Logic to add deposit amount to current balance
    double calcCurrentDeposit(double amount) {
        CB = CB + amount;
        return CB;
    }

    // Handle deposit input to saving account
    void getSavingDeposit() {
        System.out.println("Current Balance : " + df2.format(SB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if ((SB + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Saving Balance : " + df2.format(SB));
        } else {
            System.out.println("\n Invalid Money");
        }
    }

    // Logic to add deposit amount to saving balance
    double calcSavingDeposit(double amount) {
        SB = SB + amount;
        return SB;
    }
}

// OptionMenu class manages login and menu navigation
class OptionMenu extends Account {
    Scanner sc = new Scanner(System.in);

    // Stores customer number and corresponding PIN
    HashMap<Integer, Integer> data = new HashMap();

    // Handles user login
    void getLogin() {
        int i = 10;

        do {
            try {
                // Adding dummy login credentials
                data.put(1111, 111);
                data.put(1112, 112);
                data.put(1113, 113);
                data.put(1114, 114);
                data.put(1115, 115);

                System.out.println("Welcome to the ATM !");
                System.out.println("Enter the Customer Number : ");
                setCustomerNumber(sc.nextInt());
                System.out.println("Enter the PIN Number      : ");
                setPINNumber(sc.nextInt());

                int P = getCustomerNumber();
                int Q = getPINNumber();

                // Check if login is successful
                if (data.containsKey(P) && data.get(P) == Q) {
                    getAccountType();  // Go to account menu
                } else {
                    System.out.println("Login Failed");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enters only numbers");
                System.out.println("Character and Symbol not allowed.");
                sc.next();  // clear scanner buffer
                getLogin(); // retry login
            }
        } while (i == 10); // infinite loop (used as a trick to keep running)
    }

    // Menu to choose account type
    void getAccountType() {
        System.out.println("Enter the Account Type : ");
        System.out.println("\nType 1 : Current Account");
        System.out.println("\nType 2 : Saving Account");
        System.out.println("\nType 3 : Exit");
        System.out.print("\nChoice : ");

        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                getCurrent();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("** Thank You for Visiting **");
                System.out.println("** VISIT AGAIN **");
                break;
            default:
                System.out.println("Invalid Choice");
                System.out.println("Enter the Valid Choice");
                getAccountType(); // retry selection
                break;
        }
    }

    // Saving account operations menu
    void getSaving() {
        System.out.println("\n** SAVING ACCOUNT **");
        System.out.println("Type 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : EXIT");
        System.out.print("\nChoice : ");

        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                getSavingBalance();
                getAccountType(); // go back to main account type menu
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDeposit();
                getAccountType();
                break;
            case 4:
                System.out.println("** Thank You for Visiting **");
                System.out.println("** VISIT AGAIN **");
                break;
            default:
                System.out.println("Invalid Choice");
                System.out.println("Enter the Valid Choice");
                getAccountType();
                break;
        }
    }

    // Current account operations menu
    void getCurrent() {
        System.out.println("\n** CURRENT ACCOUNT **");
        System.out.println("Type 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : EXIT");
        System.out.print("\nChoice : ");

        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                getCurrentBalance();
                getAccountType(); // return to main menu
                break;
            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCurrentDeposit();
                getAccountType();
                break;
            case 4:
                System.out.println("** Thank You for Visiting **");
                System.out.println("** VISIT AGAIN **");
                break;
            default:
                System.out.println("Invalid Choice");
                System.out.println("Enter the Valid Choice");
                getAccountType();
                break;
        }
    }
}

// Main class to run the program
public class ATM extends OptionMenu {
    public static void main(String[] args) {
        OptionMenu obj = new OptionMenu();
        obj.getLogin();  // Start the login process
    }
}
