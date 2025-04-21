from typing import Dict, Any

import os
import sys

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from bank_account_system.account import Account
from bank_account_system.time_zone import TimeZone
from bank_account_system.utils import parse_confirmation_code

def main() -> None:
    """
    Interactive bank account system simulation.
    """
    print("Welcome to the Bank Account System!")
    first_name: str = input("Enter your first name: ")
    last_name: str = input("Enter your last name: ")
    balance: float = float(input("Enter your initial balance: "))
    timezone_name: str = input("Enter your preferred timezone name: ")
    timezone_offset: int = int(input("Enter your timezone offset (e.g., -5 for UTC-5): "))
    time_zone: TimeZone = TimeZone(timezone_name, timezone_offset)

    account = Account("9000-2000-1022-1921", first_name, last_name, balance, time_zone)
    print(f"\nAccount created successfully for {account.full_name} with balance {account.balance} in timezone {account._time_zone}.\n")

    while True:
        print("Choose an option:")
        print("1. Deposit")
        print("2. Withdraw")
        print("3. Check Balance")
        print("4. Pay Interest")
        print("5. Exit")
        choice = input("Enter your choice: ")

        if choice == "1":
            amount = float(input("Enter the amount to deposit: "))
            try:
                transaction = account.deposit(amount)
                parsed_transaction: Dict[str, Any] = parse_confirmation_code(transaction, timezone_offset)
                print(f"Deposit successful! New balance: {account.balance}")
                print(transaction)
                print("=== Transaction Details ===")
                print(f"Transaction Code: {parsed_transaction['transaction_code']}")
                print(f"Account Number: {parsed_transaction['account_number']}")
                print(f"Time (UTC): {parsed_transaction['time_utc']}")
                print(f"Time (Local): {parsed_transaction['time_local']}")
                print(f"Transaction ID: {parsed_transaction['transaction_id']}")
                print("===========================")
            except Exception as e:
                print(f"Error: {e}\n")

        elif choice == "2":
            amount = float(input("Enter the amount to withdraw: "))
            try:
                transaction = account.withdraw(amount)
                parsed_transaction: Dict[str, Any] = parse_confirmation_code(transaction, timezone_offset)
                print(f"Withdrawal successful! New balance: {account.balance}")
                print("=== Transaction Details ===")
                print(f"Transaction Code: {parsed_transaction['transaction_code']}")
                print(f"Account Number: {parsed_transaction['account_number']}")
                print(f"Time (UTC): {parsed_transaction['time_utc']}")
                print(f"Time (Local): {parsed_transaction['time_local']}")
                print(f"Transaction ID: {parsed_transaction['transaction_id']}")
                print("===========================")
            except Exception as e:
                print(f"Error: {e}\n")

        elif choice == "3":
            print(f"Current balance: {account.balance}\n")

        elif choice == "4":
            try:
                interest = account.calculate_interest()
                transaction = account.pay_interest()
                parsed_transaction: Dict[str, Any] = parse_confirmation_code(transaction, timezone_offset)
                print(f"Interest paid successfully! New balance: {account.balance}")
                print("=== Transaction Details ===")
                print(f"Transaction Code: {parsed_transaction['transaction_code']}")
                print(f"Account Number: {parsed_transaction['account_number']}")
                print(f"Time (UTC): {parsed_transaction['time_utc']}")
                print(f"Time (Local): {parsed_transaction['time_local']}")
                print(f"Transaction ID: {parsed_transaction['transaction_id']}")
                print("===========================")
            except Exception as e:
                print(f"Error: {e}\n")

        elif choice == "5":
            print("Thank you for using the Bank Account System. Goodbye!")
            break

        else:
            print("Invalid choice. Please try again.\n")

if __name__ == "__main__":
    main()