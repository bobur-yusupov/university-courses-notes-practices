package banktest.models;

import bank.models.Account;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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

}
