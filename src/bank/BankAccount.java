package bank;

public class BankAccount{

	private String holder;
	private double balance;
	
	public BankAccount(String holder, double balance){
		this.holder = holder;
		this.balance = balance;
	}
	
	public void deposit(double amount){
		balance += amount;
		System.out.println(amount + " was deposited into the bank account of " + holder + " - Current balance : " + balance);
	}

	public void withdraw(double amount){
		if(balance >= amount){
			balance -= amount;
			System.out.println(amount + " was withdrawn into the bank account of " + holder + " - Current balance : " + balance);
		} else {
			System.out.println("Withdrawal not possible: insufficient funds");
		}
	}

	public void transfer(BankAccount destination, double amount){
		if(balance >= amount){
			balance -= amount;
			destination.balance += amount;
			System.out.println(holder + " has transferred " + amount + " to " + destination.holder + " - Current balance: " + balance);
		} else {
			System.out.println("Transfer not possible: insufficient funds");
		}
	}

	public void checkBalance(){
		System.out.println("Current balance:" + balance);
	}
}

