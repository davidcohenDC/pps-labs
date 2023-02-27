package lab01.example.utils;

import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

/**
 * This class provides a utils method for fee
 */
public class FeeUtils {
    private static final int FEE_AMOUNT = 1;

    public static Double applyingFee(BankAccount bankAccount, double balance) {
        return bankAccount.getClass() != SimpleBankAccount.class ? balance - FEE_AMOUNT : balance;
    }

}
