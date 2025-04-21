import unittest
import os
import sys

from datetime import timedelta, datetime

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from bank_account_system.time_zone import TimeZone

class TestTimeZone(unittest.TestCase):
    def setUp(self):
        self.timezone = TimeZone("Test Time Zone", 5)
        self.offset = timedelta(hours=5)

    def test_create_time_zone(self):
        timezone = TimeZone("Test Time Zone", 5)
        self.assertEqual(timezone._timezone_name, "Test Time Zone")
        self.assertEqual(timezone._offset, self.offset)

    def test_set_name(self):
        self.timezone.name = "New Time Zone"
        self.assertEqual(self.timezone.name, "New Time Zone")

    def test_set_offset(self):
        self.timezone.offset = 3
        self.assertEqual(self.timezone.offset, 3)

    def test_get_offset_time(self):
        dt = datetime(2023, 10, 1, 12, 0, 0)
        expected_time = dt + self.offset
        self.assertEqual(self.timezone.get_offset_time(dt), expected_time)

    def test_string_representation(self):
        self.assertEqual(str(self.timezone), "Test Time Zone (UTC+5:00:00)")


if __name__ == "__main__":
    unittest.main()