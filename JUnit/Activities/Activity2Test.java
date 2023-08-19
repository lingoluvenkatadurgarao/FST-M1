package activities;


import org.junit.jupiter.api.Test;
import activities.BankAccount;
import activities.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2Test {

    @Test
    public void notEnoughFunds(){
   BankAccount BA = new BankAccount(10);
        assertThrows(NotEnoughFundsException.class,() -> BA.withdraw(100),"Balance must be greater than amount of withdrawal");
    }

    @Test
    public void enoughFunds(){
    BankAccount BA = new BankAccount(500);
        assertDoesNotThrow(() -> BA.withdraw(200),"Successfully Withdrawn");
    }
}
