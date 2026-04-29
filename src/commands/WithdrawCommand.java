package commands;
import bank.BankAccount;

public class WithdrawCommand implements Command{

	private BankAccount account;
	private double amount;

	public WithdrawCommand(BankAccount account, double amount){
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute(){
		account.withdraw(amount);
	}

	@Override
	public void undo(){
		account.deposit(amount);
	}
}
