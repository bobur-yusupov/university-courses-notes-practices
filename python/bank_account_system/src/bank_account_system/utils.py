"""

Utility functions for the bank account system.
This module contains utility functions for parsing confirmation codes and handling time zones.

"""
from datetime import datetime, timedelta, timezone
from typing import Dict, Any

import os
import sys

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from bank_account_system.exceptions import InvalidConfirmationCodeError
from bank_account_system.time_zone import TimeZone

def parse_confirmation_code(code: str, preferred_timezone_offset: int) -> Dict[str, Any]:
    """
    Parse the confirmation code and return a structured dictionary with attributes.

    :param code: Confirmation code
    :param preferred_timezone_offset: Timezone offset for local time
    :return: Dictionary with transaction details
    """
    parts: list[str] = code.split('|')

    if len(parts) != 4:
        raise InvalidConfirmationCodeError("Invalid confirmation code format.")
    
    transaction_code: str = parts[0]
    account_number: str = parts[1]
    timestamp_str: str = parts[2]
    transaction_id: int = int(parts[3])

    utc_timestamp: datetime = datetime.strptime(timestamp_str, "%Y-%m-%dT%H:%M:%S")
    timezone_offset: timedelta = timedelta(hours=preferred_timezone_offset)
    local_timestamp: datetime = utc_timestamp + timezone_offset

    return {
        "transaction_code": transaction_code,
        "account_number": account_number,
        "time_utc": utc_timestamp,
        "time_local": local_timestamp,
        "transaction_id": transaction_id
    }

def generate_confirmation_code(
    transaction_type: str,
    account_number: str,
    transaction_id: int
) -> str:
    """
    Generate a confirmation code for a transaction.

    :param transaction_type: Type of transaction (e.g., "deposit", "withdraw")
    :param account_number: Account number associated with the transaction
    :param transaction_id: Unique transaction ID
    :param local_timezone: TimeZone object representing the local timezone
    :return: Confirmation code as a string
    """
    utc_now: datetime = datetime.now(timezone.utc)
    confirmation_code: str = f"{transaction_type.upper()}|{account_number}|{utc_now.strftime('%Y-%m-%dT%H:%M:%S')}|{transaction_id}"

    return confirmation_code