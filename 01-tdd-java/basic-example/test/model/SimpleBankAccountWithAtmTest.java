package model;

import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    @Override
    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccount(accountHolder, 0);
    }
}
