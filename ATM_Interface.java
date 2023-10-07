import java.util.Scanner;

 class BankAccount {

    private double balance;

    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        //This deposit function we will use add the amount to our bankaccount.
        if (amount > 0) {
            balance += amount;
            System.out.println("Money Deposited: " + amount);

        } else {
            System.out.println("Invalid amount for deposit !!");

        }
    }

    public void withdraw(double amount) {
        //This withdraw function we will use deduct the amount from our account
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Money withdraw:" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal !");
        }
    }
}

    class ATM {
        private BankAccount account;
        private Scanner scanner;

    

       public ATM(BankAccount account){
         this.account=account;
         this.scanner=new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("<--*****WELCOME TO ATM *****-->");
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit");
    }

    public void start(){
        int choice;
        do{
            showMenu();
            System.out.println("Enter Your Choice:-");
            choice=scanner.nextInt();
            switch(choice){
                case 1 :
                     checkBalance();
                     break;
                case 2:
                     deposit();
                     break;

                case 3:
                     withdraw();
                     break;

                case 4:
                     System.out.println("Exiting ATM Thank you");
                     break;

                default:
                     System.out.println("Invalid choice. Please select a valid option");

            }
        }while(choice!=4);

    }

    private void checkBalance(){
        System.out.println("Current Balance: "+account.getBalance());

    }

    private void deposit(){
        System.out.println("Enter Deposit Amount :-");
        double amount =scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw(){
        System.out.println("Enter the Withdrawal amount :-");
        double amount=scanner.nextDouble();
        account.withdraw(amount);
    }
}

    public class ATM_Interface{
        public static void main(String args[]){

            System.out.println("Welcome to the ATM :-");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your Four Digit PIN :-");
            int enteredPin=sc.nextInt();

            BankAccount userAccount=new BankAccount(1000.0);
            ATM atm=new ATM(userAccount);
            atm.start();


        }
    }


