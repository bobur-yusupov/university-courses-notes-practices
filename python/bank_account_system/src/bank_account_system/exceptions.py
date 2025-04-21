class NegativeAmountError(Exception):
    """
    Exception raised for negative amounts in transactions.
    """
    def __init__(self, message: str) -> None:
        super().__init__(message)
        self.message = message

class InsufficientFundsError(Exception):
    """
    Exception raised for insufficient funds in the account.
    """
    def __init__(self, message: str) -> None:
        super().__init__(message)
        self.message = message

class InvalidConfirmationCodeError(Exception):
    """
    Exception raised for invalid confirmation codes.
    """
    def __init__(self, message: str) -> None:
        super().__init__(message)
        self.message = message