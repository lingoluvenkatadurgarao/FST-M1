package activities;

public class BankAccount {
    private Integer balance;
    public BankAccount(Integer IntialBalance){
        balance = IntialBalance;
    }

    public Integer withdraw(Integer Amount){
        if(balance < Amount){
            throw new NotEnoughFundsException(Amount, balance);
        }
        balance -=Amount;
        return balance;
    }
}

class NotEnoughFundsException extends RuntimeException{
public NotEnoughFundsException(Integer Amount, Integer balance){
    super("Attempted to withdraw" + Amount + "With the balance of " + balance);
}
}