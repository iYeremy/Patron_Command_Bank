package commands;
import bank.BankAccount;

public class CheckBalanceCommand implements Command{

	private BankAccount account;

	public CheckBalanceCommand(BankAccount account){
		this.account = account;
	}

	@Override
	public void execute(){
		account.checkBalance();
	}

	@Override
	public void undo(){
		System.out.println("Action not available: cannot be reversed");
	}
}
