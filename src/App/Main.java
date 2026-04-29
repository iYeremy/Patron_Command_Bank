package App;

import bank.ATM;
import bank.BankAccount;
import commands.CheckBalanceCommand;
import commands.DepositCommand;
import commands.TransferCommand;
import commands.WithdrawCommand;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);
        ATM atm = new ATM();

        System.out.println("--- Initial Balances ---");
        atm.executeOP(new CheckBalanceCommand(account1));
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();

        System.out.println("--- Transaction 1: Alice Deposits $200 ---");
        DepositCommand depositAlice = new DepositCommand(account1, 200.0);
        atm.executeOP(depositAlice);
        atm.executeOP(new CheckBalanceCommand(account1));
        System.out.println();

        System.out.println("--- Transaction 2: Bob Withdraws $100 ---");
        WithdrawCommand withdrawBob = new WithdrawCommand(account2, 100.0);
        atm.executeOP(withdrawBob);
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();

        System.out.println("--- Transaction 3: Alice Transfers $300 to Bob ---");
        TransferCommand transferAliceToBob = new TransferCommand(account1, account2, 300.0);
        atm.executeOP(transferAliceToBob);
        atm.executeOP(new CheckBalanceCommand(account1));
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();

        System.out.println("--- Transaction 4: Alice Tries to Withdraw $1500 (Insufficient Funds) ---");
        WithdrawCommand withdrawAliceFailed = new WithdrawCommand(account1, 1500.0);
        atm.executeOP(withdrawAliceFailed);
        atm.executeOP(new CheckBalanceCommand(account1));
        System.out.println();

        System.out.println("--- Undoing Last Successful Transaction (Alice's Transfer) ---");
        atm.undoOP(transferAliceToBob); // This will call undo on the last pushed command (transferAliceToBob)
        atm.executeOP(new CheckBalanceCommand(account1));
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();
        
        System.out.println("--- Undoing Bob's Withdrawal ---");
        atm.undoOP(withdrawBob);
        atm.executeOP(new CheckBalanceCommand(account2));
        System.out.println();
    }
}
