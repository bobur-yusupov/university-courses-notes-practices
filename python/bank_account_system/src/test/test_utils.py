import sys
import os
import unittest
from datetime import timedelta, datetime

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from bank_account_system.utils import parse_confirmation_code
from bank_account_system.exceptions import InvalidConfirmationCodeError
from bank_account_system.time_zone import TimeZone

class TestUtils(unittest.TestCase):
    def test_parse_confirmation_code(self):
        code: str = "DEPOSIT|9000-2000-1022-1921|2025-04-21T13:12:48|1"
        timezone: TimeZone = TimeZone("UTC", 0)

        expected_result: dict = {
            "transaction_code": "DEPOSIT",
            "account_number": "9000-2000-1022-1921",
            "time_utc": datetime(2025, 4, 21, 13, 12, 48),
            "time_local": datetime(2025, 4, 21, 13, 12, 48) + timedelta(hours=0),
            "transaction_id": 1,
        }
        result: dict = parse_confirmation_code(code, 0)

        self.assertEqual(result, expected_result)
