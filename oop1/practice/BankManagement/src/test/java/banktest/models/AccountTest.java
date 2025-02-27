package banktest.models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import bank.models.Account;
import bank.models.Transaction;
import bank.exceptions.InsufficientFundsException;

import java.util.Date;

public class AccountTest {
    private Account account1;

    @BeforeEach
    public void setUp() {
        account1 = new Account("12345", "John Doe", 1000.0);
    }

    @Test
    public void testGetAccountNumberTest() {
        assertEquals("12345", account1.getAccountNumber());
    }

    @Test
    public void setNewAccountNumberTest() {
        account1.setAccountNumber("54321");

        assertEquals("54321", account1.getAccountNumber());
    }

    @Test
    public void getAccountHolderTest() {
        assertEquals("John Doe", account1.getAccountHolder());
    }

    @Test
    public void setNewAccountHolderTest() {
        Account account2 = new Account("12345", "John Doe", 1000.0);
        account2.setAccountHolder("Doe John");

        assertEquals("Doe John", account2.getAccountHolder());
    }

    @Test
    public void withdrawMoneyTest() {
        account1.withdraw(10);

        assertEquals(990, account1.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmountTest() {
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-100.0));
    }

    @Test
    public void testWithdrawZeroAmountTest() {
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(0.0));
    }

    @Test
    public void testWithdrawMoreThanBalanceTest() {
        assertThrows(InsufficientFundsException.class, () -> account1.withdraw(1001.0));
    }

    @Test
    public void depositMoneyTest() {
        account1.deposit(10);

        assertEquals(1010, account1.getBalance());
    }

    @Test
    public void testDepositNegativeAmountTest() {
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-100.0));
    }

    @Test
    public void testDepositZeroAmountTest() {
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(0.0));
    }

    @Test
    public void testAddTransactionTest() {
        assertEquals(0, account1.getTransactionHistory().size());
    }

    @Test
    public void testAddTransactionHistoryTest() {
        account1.addTransaction(new Transaction("12345", "54321", 100.0, new Date(), "deposit"));

        assertEquals(1, account1.getTransactionHistory().size());
    }

    @Test
    public void testGetBalanceTest() {
        assertEquals(1000.0, account1.getBalance());
    }

    @Test
    public void testGetTransactionHistoryTest() {
        assertEquals(0, account1.getTransactionHistory().size());
    }

    @Test
    public void testGetTransactionHistorySizeTest() {
        account1.addTransaction(new Transaction("12345", "54321", 100.0, new Date(), "deposit"));
        account1.addTransaction(new Transaction("54321", "12345", 50.0, new Date(), "withdraw"));

        assertEquals(2, account1.getTransactionHistory().size());
    }
}
