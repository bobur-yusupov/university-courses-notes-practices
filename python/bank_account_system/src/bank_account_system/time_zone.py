"""

This module provides a function to get the current time in a specified timezone.

"""

from datetime import datetime, timezone, timedelta
from typing import Dict, Any

import os
import sys

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

class TimeZone:
    def __init__(self, timezone_name: str, offset: int) -> None:
        self._timezone_name: str = timezone_name
        self._offset: timedelta = timedelta(hours=offset)

    def get_offset_time(self, dt: datetime) -> datetime:
        """
        Get the current time in the specified timezone.

        :param dt: A datetime object
        :return: Current time in the specified timezone
        """
        return dt + self._offset
    
    def __str__(self) -> str:
        """
        Get the string representation of the timezone.

        :return: String representation of the timezone
        """
        return f"{self._timezone_name} (UTC{'+' if self._offset >= timedelta(0) else ''}{self._offset})"
