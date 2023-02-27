package model;

import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import lab01.example.utils.FeeUtils;
import org.junit.jupiter.api.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccount(accountHolder, 0);
    }


    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }
    private final static int DEPOSIT_AMOUNT = 100;
    private final static int WITHDRAW_AMOUNT = 70;

    @Test
    void testDeposit() {
        double amount = 0;
        amount = this.depositWithAmount(accountHolder.getId(),DEPOSIT_AMOUNT,amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        double amount = 0;
        amount = this.depositWithAmount(accountHolder.getId(),DEPOSIT_AMOUNT, amount);
        Random ran = new Random();
        int randomDepositValue = ran.nextInt(6) + 5;
        this.bankAccount.deposit(2,randomDepositValue);
        assertEquals(amount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        double amount = 0;
        amount = depositWithAmount(accountHolder.getId(), DEPOSIT_AMOUNT, amount);
        amount = withdrawWithAmount(accountHolder.getId(), WITHDRAW_AMOUNT, amount);
        assertEquals(amount, bankAccount.getBalance());
    }
    @Test
    void testWrongWithdraw() {
        double amount = 0;
        amount = depositWithAmount(accountHolder.getId(), DEPOSIT_AMOUNT, amount);
        this.bankAccount.withdraw(2, WITHDRAW_AMOUNT);
        assertEquals(amount, bankAccount.getBalance());
    }

    private double depositWithAmount(int id, double deposit, double amount) {
        this.bankAccount.deposit(id, deposit);
        amount += deposit;
        return FeeUtils.applyingFee(bankAccount,amount);
    }

    private double withdrawWithAmount(int id, double withdraw, double amount) {
        this.bankAccount.withdraw(id, withdraw);
        amount -= withdraw;
        return FeeUtils.applyingFee(bankAccount,amount);
    }

}
