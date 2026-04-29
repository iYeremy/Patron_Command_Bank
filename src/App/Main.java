package App;

import bank.ATM;
import bank.BankAccount;
import commands.CheckBalanceCommand;
import commands.DepositCommand;
import commands.TransferCommand;
import commands.WithdrawCommand;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Miku", 1000.0);
        BankAccount account2 = new BankAccount("Pepe", 500.0);
        ATM atm = new ATM();

        System.out.println("--- Initial Balances ---");
        atm.executeOP(new CheckBalanceCommand(account1));
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();

        System.out.println("--- Transaction 1: Miku Deposits $200 ---");
        DepositCommand depositMiku = new DepositCommand(account1, 200.0);
        atm.executeOP(depositMiku);
        atm.executeOP(new CheckBalanceCommand(account1));
        System.out.println();

        System.out.println("--- Transaction 2: Pepe Withdraws $100 ---");
        WithdrawCommand withdrawPepe = new WithdrawCommand(account2, 100.0);
        atm.executeOP(withdrawPepe);
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();

        System.out.println("--- Transaction 3: Miku Transfers $300 to Pepe ---");
        TransferCommand transferMikuToPepe = new TransferCommand(account1, account2, 300.0);
        atm.executeOP(transferMikuToPepe);
        atm.executeOP(new CheckBalanceCommand(account1));
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();

        System.out.println("--- Transaction 4: Miku Tries to Withdraw $1500 (Insufficient Funds) ---");
        WithdrawCommand withdrawMikuFailed = new WithdrawCommand(account1, 1500.0);
        atm.executeOP(withdrawMikuFailed);
        atm.executeOP(new CheckBalanceCommand(account1));
        System.out.println();

        System.out.println("--- Undoing Last Successful Transaction (Miku's Transfer) ---");
        atm.undoOP(transferMikuToPepe); 
        atm.executeOP(new CheckBalanceCommand(account1));
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();
        
        System.out.println("--- Undoing Pepe's Withdrawal ---");
        atm.undoOP(withdrawPepe);
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();
    }
}
