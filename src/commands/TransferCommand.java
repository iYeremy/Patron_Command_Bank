package commands;
import bank.BankAccount;

public class TransferCommand implements Command{

	private BankAccount origin;
	private BankAccount destination;
	private double amount;

	public TransferCommand(BankAccount origin, BankAccount destination, double amount){
		this.origin = origin;
		this.destination = destination;
		this.amount = amount;
	}

	@Override
	public void execute(){
		origin.transfer(destination, amount);
	}

	@Override
	public void undo(){
		destination.transfer(origin, amount);
	}
}
