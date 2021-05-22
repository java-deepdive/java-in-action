package kr.seok;

import kr.seok.testdome.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private final double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositDoesntAcceptNegativeValue() {
        Account account = new Account(20);
        final boolean result = account.deposit(-10);

        assertEquals(0d, account.getBalance(), epsilon);
        assertFalse(result);
    }

    @Test
    public void withdrawDoesntAcceptNegativeValue() {
        Account account = new Account(20);
        final boolean result = account.withdraw(-10);

        assertEquals(0d, account.getBalance(), epsilon);
        assertFalse(result);
    }

    @Test
    public void depositPositiveValueOk() {
        Account account = new Account(20);
        final boolean result = account.deposit(10);

        assertEquals(10d, account.getBalance(), epsilon);
        assertTrue(result);
    }

    @Test
    public void withdrawPositiveValueOverdraftOk() {
        Account account = new Account(20);
        final boolean result = account.withdraw(10);

        assertEquals(-10d, account.getBalance(), epsilon);
        assertTrue(result);
    }

    @Test
    public void withdrawPositiveValueBalanceOk() {
        Account account = new Account(0);
        account.deposit(20);
        final boolean result = account.withdraw(10);

        assertEquals(10d, account.getBalance(), epsilon);
        assertTrue(result);
    }

    @Test
    public void accountCannotOverstepOverdraftLimit() {
        Account account = new Account(20);
        final boolean result = account.withdraw(30);

        assertEquals(0d, account.getBalance(), epsilon);
        assertFalse(result);
    }
}
