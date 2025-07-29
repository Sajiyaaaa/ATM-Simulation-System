import java.util.*;
import java.text.*;
class Account
{
    Scanner sc = new Scanner(System.in);
    DecimalFormat df1 = new DecimalFormat("##,###0.00' Rupee'");
    DecimalFormat df2 = new DecimalFormat("##,###0.00' Rupee'");
    private int cn;
    private int pn;
    double CB = 2000;
    double SB = 1000;
    void setCustomerNumber(int cn) //setters
    {
        this.cn = cn;
    }
    void setPINNumber(int pn)  //setters
    {
        this.pn = pn;
    }
    int getCustomerNumber()  //getters
    {
        return cn;
    }
    int getPINNumber()    //getters
    {
        return pn;
    }
    void getCurrentBalance()
    {
        System.out.println("Current Balance : "+df1.format(CB));
    }
    void getSavingBalance()
    {
        System.out.println("Saving Balance : "+df1.format(SB));

    }
    void getCurrentWithdrawInput()
    {
        System.out.println("Current Balance : "+df1.format(CB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if((CB-amount)>=0)
        {
            calcCurrentWithdraw(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Current Balance : "+df1.format(CB));
        }
        else
        {
            System.out.println("\n Insufficient Balance");
        }
    }
    double calcCurrentWithdraw(double amount)
    {
      CB = CB - amount;
      return CB;
    }

    void getSavingWithdrawInput()
    {
        System.out.println("Current Balance : "+df2.format(SB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if((SB-amount)>=0)
        {
            calcSavingWithdraw(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Saving Balance : "+df2.format(SB));
        }
        else
        {
            System.out.println("\n Insufficient Balance");
        }
    }
    double calcSavingWithdraw(double amount)
    {
        SB = SB - amount;
        return SB;
    }

    void getCurrentDeposit()
    {
        System.out.println("Current Balance : "+df1.format(CB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if((CB+amount)>=0)
        {
            calcCurrentDeposit(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Current Balance : "+df1.format(CB));
        }
        else
        {
            System.out.println("\n Invalid Money");
        }
    }
    double calcCurrentDeposit(double amount)
    {
        CB = CB + amount;
        return CB;
    }

    void getSavingDeposit()
    {
        System.out.println("Current Balance : "+df2.format(SB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount = sc.nextDouble();

        if((SB+amount)>=0)
        {
            calcSavingDeposit(amount);
            System.out.println("Transaction Successfull !");
            System.out.println("Saving Balance : "+df2.format(SB));
        }
        else
        {
            System.out.println("\n Invalid Money");
        }
    }
    double calcSavingDeposit(double amount)
    {
        SB = SB + amount;
        return SB;
    }


}
class OptionMenu extends Account
{
    Scanner sc = new Scanner(System.in);
    HashMap<Integer,Integer> data = new HashMap();
    void getLogin()
    {
        int i = 10;
        do {
            try
            {
                data.put(1111,111);
                data.put(1112,112);
                data.put(1113,113);
                data.put(1114,114);
                data.put(1115,115);

                System.out.println("Welcome to the ATM !");
                System.out.println("Enter the Customer Number : ");
                setCustomerNumber(sc.nextInt());
                System.out.println("Enter the PIN Number      : ");
                setPINNumber(sc.nextInt());

                int P = getCustomerNumber();
                int Q = getPINNumber();

                if(data.containsKey(P) && data.get(P) == Q){
                    getAccountType();

                }else{
                    System.out.println("Login Failed");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Enters only numbers");
                System.out.println("Character and Symbol not allowed.");
                sc.next();
                getLogin();
            }
        }while(i==10);
    }
    void getAccountType()
    {
        System.out.println("Enter the Account Type : ");
        System.out.println("\nType 1 : Current Account");
        System.out.println("\nType 2 : Saving Account");
        System.out.println("\nType 3 : Exit");
        System.out.print("\nChoice : ");

        int ch = sc.nextInt();
        switch(ch){
            case 1 : getCurrent();
                break;
            case 2 : getSaving();
                break;
            case 3 :
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
    void getSaving()
    {
        System.out.println("\n** SAVING ACCOUNT **");
        System.out.println("Type 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : EXIT");
        System.out.print("\nChoice : ");

        int ch =sc.nextInt();

        switch(ch){
            case 1 : getSavingBalance();
                    getAccountType();
                break;
            case 2 : getSavingWithdrawInput();
                getAccountType();
                break;
            case 3 : getSavingDeposit();
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
    void getCurrent()
    {
        System.out.println("\n** CURRENT ACCOUNT **");
        System.out.println("Type 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : EXIT");
        System.out.print("\nChoice : ");

        int ch =sc.nextInt();

        switch(ch){
            case 1 : getCurrentBalance();
                getAccountType();
                break;
            case 2 : getCurrentWithdrawInput();
                getAccountType();
                break;
            case 3 : getCurrentDeposit();;
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
public class ATM extends OptionMenu
{
    public static void main(String[] args)
    {
        OptionMenu obj = new OptionMenu();
        obj.getLogin();

    }
}
