import unittest
import os
import sys

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from bank_account_system.account import Account
from bank_account_system.time_zone import TimeZone
from bank_account_system import exceptions

class TestAccount(unittest.TestCase):
    def setUp(self):
        self.timezone = TimeZone("Test Time Zone", 5)
        self.account1 = Account(account_number="9000-2000-1022-1921", first_name="John", last_name="Doe", balance=1000.0, time_zone=self.timezone)

    def test_create_bank_account(self):
        timezone = TimeZone("Test Time Zone", 4)
        account = Account(account_number="9000-2000-1022-2021", first_name="John", last_name="Doe", balance=1000.0, time_zone=timezone)

        self.assertEqual(account.first_name, "John")
        self.assertEqual(account.last_name, "Doe")
        self.assertEqual(account.balance, 1000.0)
        self.assertEqual(account._account_number, "9000-2000-1022-2021")
        self.assertEqual(account._time_zone, timezone)
        self.assertEqual(account.interest_rate, 0.05)
    
    def test_set_first_and_last_name(self):
        self.account1.first_name = "Jane"
        self.account1.last_name = "Smith"

        self.assertEqual(self.account1.first_name, "Jane")
        self.assertEqual(self.account1.last_name, "Smith")

    def test_get_full_name(self):
        self.assertEqual(self.account1.full_name, "John Doe")
        self.account1.first_name = "Jane"
        self.assertEqual(self.account1.full_name, "Jane Doe")

    def test_balance(self):
        self.assertEqual(self.account1.balance, 1000.0)
        self.account1.deposit(500.0)
        self.assertEqual(self.account1.balance, 1500.0)

    def test_account_withdraw_money(self):
        confirmation = self.account1.withdraw(200.0)
        self.assertTrue(confirmation.startswith("WITHDRAW"))
        self.assertEqual(self.account1.balance, 800.0)
    
    def test_negative_amount_money_withdraw(self):
        with self.assertRaises(exceptions.NegativeAmountError):
            self.account1.withdraw(-100.0)
        self.assertEqual(self.account1.balance, 1000.0)

    def test_insufficient_funds_money_withdraw(self):
        with self.assertRaises(exceptions.InsufficientFundsError):
            self.account1.withdraw(2000.0)
        self.assertEqual(self.account1.balance, 1000.0)

    def test_account_deposit_money(self):
        confirmation = self.account1.deposit(500.0)
        self.assertTrue(confirmation.startswith("DEPOSIT"))
        self.assertEqual(self.account1.balance, 1500.0)

    def test_negative_amount_money_deposit(self):
        with self.assertRaises(exceptions.NegativeAmountError):
            self.account1.deposit(-100.0)
        self.assertEqual(self.account1.balance, 1000.0)

    def test_calculate_interest(self):
        interest_earned = self.account1.interest_rate * self.account1.balance
        self.assertEqual(self.account1.calculate_interest(), interest_earned)
    
    def test_pay_interest(self):
        initial_balance = self.account1.balance
        interest_earned = self.account1.calculate_interest()
        confirmation = self.account1.pay_interest()
        self.assertTrue(confirmation.startswith("INTEREST"))
        self.assertEqual(self.account1.balance, initial_balance + interest_earned)

    def test_string_representation(self):
        expected_str = f"Account Number: {self.account1._account_number}, Name: {self.account1.full_name}, Balance: {self.account1.balance}, Time Zone: {self.account1._time_zone}"
        self.assertEqual(str(self.account1), expected_str)


if __name__ == "__main__":
    unittest.main()