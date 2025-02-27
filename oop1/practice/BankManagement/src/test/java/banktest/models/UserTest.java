package banktest.models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import bank.models.User;
import bank.models.Account;

public class UserTest {
    private User user1;

    @BeforeEach
    public void setUp() {
        user1 = new User("12345", "John Doe", "johndoe@gmail.com");
    }

    @Test
    public void testGetUserIdTest() {
        assertEquals("12345", user1.getUserId());
    }

    @Test
    public void testGetNameTest() {
        assertEquals("John Doe", user1.getName());
    }

    @Test
    public void testGetEmailTest() {
        assertEquals("johndoe@gmail.com", user1.getEmail());
    }

    @Test
    public void testAddAccountTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        user1.addAccount(account1);

        assertEquals(1, user1.getAccounts().size());
    }

    @Test
    public void testGetAccountsTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        user1.addAccount(account1);

        assertEquals(1, user1.getAccounts().size());
    }

    @Test
    public void testGetAccountsEmptyTest() {
        assertEquals(0, user1.getAccounts().size());
    }

    @Test
    public void testGetAccountsMultipleTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("54321", "Doe John", 2000.0);
        user1.addAccount(account1);
        user1.addAccount(account2);

        assertEquals(2, user1.getAccounts().size());
    }

    @Test
    public void testGetAccountsMultipleOrderTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("54321", "Doe John", 2000.0);
        user1.addAccount(account1);
        user1.addAccount(account2);

        assertEquals(account1, user1.getAccounts().get(0));
        assertEquals(account2, user1.getAccounts().get(1));
    }

    @Test
    public void testGetAccountsMultipleOrderReverseTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("54321", "Doe John", 2000.0);
        user1.addAccount(account2);
        user1.addAccount(account1);

        assertEquals(account2, user1.getAccounts().get(0));
        assertEquals(account1, user1.getAccounts().get(1));
    }

    @Test
    public void testGetAccountsMultipleOrderReverseRemoveTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("54321", "Doe John", 2000.0);
        user1.addAccount(account2);
        user1.addAccount(account1);
        user1.getAccounts().remove(0);

        assertEquals(account1, user1.getAccounts().get(0));
    }

    @Test
    public void testGetAccountsMultipleOrderReverseRemoveSizeTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("54321", "Doe John", 2000.0);
        user1.addAccount(account2);
        user1.addAccount(account1);
        user1.getAccounts().remove(0);

        assertEquals(1, user1.getAccounts().size());
    }

    @Test
    public void testGetAccountsMultipleOrderReverseRemoveSizeZeroTest() {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("54321", "Doe John", 2000.0);
        user1.addAccount(account2);
        user1.addAccount(account1);
        user1.getAccounts().remove(0);
        user1.getAccounts().remove(0);

        assertEquals(0, user1.getAccounts().size());
    }
}
