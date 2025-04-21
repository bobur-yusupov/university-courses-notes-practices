"""
Account class to manage Bank Account related operations.
This class is responsible for creating a bank account, depositing money, withdrawing money, and checking the balance.

"""
from datetime import datetime, timezone
from typing import List, Dict, Union

import os
import sys

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from bank_account_system.exceptions import NegativeAmountError, InsufficientFundsError
from bank_account_system.time_zone import TimeZone

class Account:
    interest_rate: float = 0.05
    transaction_id: int = 1

    def __init__(
        self, 
        account_number: str, 
        first_name: str, 
        last_name: str, 
        balance: float = 0.0, 
        time_zone: Union[TimeZone, None] = None
    ) -> None:
        """
        Initialize the account with account number, first name, last name and initial balance.

        :param account_number: Unique identifier for the account
        :param first_name: First name of the account holder
        :param last_name: Last name of the account holder
        :param balance: Initial balance of the account (default is 0.0)
        """
        self._account_number: str = account_number
        self._first_name: str = first_name
        self._last_name: str = last_name
        self._balance: float = balance
        self._time_zone: TimeZone = time_zone if time_zone else TimeZone("UTC", 0)
        self._transactions: List[Dict[str, Union[str, float, datetime]]] = []

    @property
    def first_name(self) -> str:
        """
        Get the first name of the account holder.

        :return: First name of the account holder
        """
        return self._first_name
    
    @first_name.setter
    def first_name(self, first_name: str) -> None:
        """
        Set the first name of the account holder.

        :param first_name: First name of the account holder
        """
        self._first_name = first_name

    @property
    def last_name(self) -> str:
        """
        Get the last name of the account holder.

        :return: Last name of the account holder
        """
        return self._last_name
    
    @last_name.setter
    def last_name(self, last_name: str) -> None:
        """
        Set the last name of the account holder.

        :param last_name: Last name of the account holder
        """
        self._last_name = last_name
    
    @property
    def full_name(self) -> str:
        """
        Get the full name of the account holder.

        :return: Full name of the account holder
        """
        return f"{self._first_name} {self._last_name}"
    
    @property
    def balance(self) -> float:
        """
        Get the current balance of the account.

        :return: Current balance of the account
        """
        return self._balance
    
    @classmethod
    def increment_transaction_id(cls) -> None:
        """
        Increment the transaction ID for each transaction.

        :return: None
        """
        cls.transaction_id += 1

    @classmethod
    def set_interest_rate(cls, new_rate: float) -> None:
        """
        Set a new interest rate for all accounts.

        :param new_rate: New interest rate as a float
        """
        cls.interest_rate = new_rate
    
    def withdraw(self, amount: float) -> str:
        """
        Withdraw money from the account.

        :param amount: Amount to withdraw
        :return: Confirmation code if successful, else an error message
        :raises NegativeAmountError: If the withdrawal amount is negative
        :raises InsufficientFundsError: If the withdrawal amount exceeds the current balance
        """
        if amount < 0:
            raise NegativeAmountError("Withdrawal amount cannot be negative")

        if amount > self._balance:
            raise InsufficientFundsError("Insufficient funds for withdrawal")
        
        utc_now: datetime = datetime.now(timezone.utc)
        local_time: datetime = self._time_zone.get_offset_time(utc_now)

        self._transactions.append({
            "transaction_type": "Withdrawal",
            "amount": amount,
            "timestamp_utc": utc_now,
            "timestamp_local": local_time,
        })

        self._balance -= amount
        confirmation_code: str = f"WITHDRAW|{self._account_number}|{utc_now.strftime('%Y-%m-%dT%H:%M:%S')}|{self.transaction_id}"
        self.increment_transaction_id()

        return confirmation_code
    
    def deposit(self, amount: float) -> str:
        """
        Deposit money into the account.

        :param amount: Amount to deposit
        :return: Confirmation code if successful, else an error message
        :raises NegativeAmountError: If the deposit amount is negative
        """
        
        if amount <= 0:
            raise NegativeAmountError("Deposit amount must be positive")
        
        utc_now: datetime = datetime.now(timezone.utc)
        local_time: datetime = self._time_zone.get_offset_time(utc_now)

        self._transactions.append({
            "transaction_type": "Deposit",
            "amount": amount,
            "timestamp_utc": utc_now,
            "timestamp_local": local_time,
        })

        self._balance += amount
        confirmation_code: str = f"DEPOSIT|{self._account_number}|{utc_now.strftime('%Y-%m-%dT%H:%M:%S')}|{self.transaction_id}"
        self.increment_transaction_id()

        return confirmation_code

    def calculate_interest(self) -> float:
        """
        Calculate interest on the current balance.

        :return: Calculated interest
        """
        interest: float = self._balance * self.interest_rate
        
        return interest
    
    def pay_interest(self) -> Union[str, bool]:
        """
        Pay interest on the current balance.

        :return: Confirmation code if successful, else an error message
        """
        interest: float = self.calculate_interest()
        
        if interest <= 0:
            print("No interest to pay")
            return False
        
        utc_now: datetime = datetime.now(timezone.utc)
        local_time: datetime = self._time_zone.get_offset_time(utc_now)
        self._transactions.append({
            "transaction_type": "Interest Payment",
            "amount": interest,
            "timestamp_utc": utc_now,
            "timestamp_local": local_time,
        })

        self._balance += interest
        confirmation_code: str = f"INTEREST|{self._account_number}|{utc_now.strftime('%Y-%m-%dT%H:%M:%S')}|{self.transaction_id}"
        self.increment_transaction_id()

        return confirmation_code
    
    def __str__(self) -> str:
        """
        Method to represent the account as a string.
        """

        return f"Account Number: {self._account_number}, Name: {self.full_name}, Balance: {self._balance}, Time Zone: {self._time_zone}"