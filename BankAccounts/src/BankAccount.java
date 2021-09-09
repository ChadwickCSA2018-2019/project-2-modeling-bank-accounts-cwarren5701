/* This class encapsulates data for checking and savings accounts
and provides an API that allows deposits and withdrawals to be made
to these accounts.
*/
public class BankAccount {
    private String name;
    private int checkMoney;
    private int saveMoney;

    public static void main(String[] args) {
    	
    	//creating new objects of the BankAccount class
    	BankAccount nicksAcct = new BankAccount("Nick", 450, 550);  	
    	BankAccount carolsAcct = new BankAccount("Carol", 600, 700);
    	
    	//calling the printReport method for both object of BankAccount class
    	nicksAcct.printReport();    	
    	carolsAcct.printReport();
    	
    	//adding the values of each account one by one to the totalMoney variable until the amount represented the true total amount 
    	int totalMoney = nicksAcct.getCheckMoney();    	
    	totalMoney = totalMoney + nicksAcct.getSaveMoney();   	
    	totalMoney = totalMoney + carolsAcct.getCheckMoney();   	
    	totalMoney = totalMoney + carolsAcct.getSaveMoney();
    	
    	//printing total amount
    	System.out.println("Total money in all accounts: $" + totalMoney);	
    	
    	//adding $100 to nicks checking account and printing that value 
    	nicksAcct.makeCheckingDeposit(100);
    	nicksAcct.printReport();
    	
    	//putting the exact amount of money in carols accounts that was in nicks without removing it from nicks
    	carolsAcct.makeCheckingDeposit(nicksAcct.getCheckMoney());    	
    	carolsAcct.makeCheckingDeposit(nicksAcct.getSaveMoney());
    	
    	//removing the money just moved into carols out of nicks account
    	nicksAcct.makeCheckingWithdrawal(nicksAcct.getCheckMoney()); 	
    	nicksAcct.makeSavingsWithdrawal(nicksAcct.getSaveMoney());
    	
    	//printing final reports
    	nicksAcct.printReport();
    	carolsAcct.printReport();
    }
    
    
    public BankAccount(String who, int checking, int saving) {
        name = who;
        checkMoney = checking;
        saveMoney = saving;
    }

    public String getAccountName() {
        return name;
    }

    public int getCheckMoney() {
        return checkMoney;
    }

    public int getSaveMoney() {
        return saveMoney;
    }

    public void makeCheckingDeposit(int amt) {
        checkMoney = checkMoney + amt;
    }

    public void makeSavingsDeposit(int amt) {
        saveMoney = saveMoney + amt;
    }

    public void makeCheckingWithdrawal(int amt) {
        if (checkMoney >= amt)
            checkMoney = checkMoney - amt;
    }

    public void makeSavingsWithdrawal(int amt) {
        if (saveMoney >= amt)
            saveMoney = saveMoney - amt;
    }

    // prints name and both account balances to the console
    public void printReport() {
        System.out.println(name + " checking: " + checkMoney + " savings: " + saveMoney);
    }
}