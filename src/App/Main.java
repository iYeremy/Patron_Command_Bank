package App;

import bank.ATM;
import bank.BankAccount;

public class Main{
	public static void main(String[] args) {
		
		BankAccount account1 = new BankAccount("Neru", 1000);
		BankAccount account2 = new BankAccount("Teto", 2000);
		BankAccount account3 = new BankAccount("Miku", 1500);

		ATM atm = new ATM();

	}
}
