# Online Banking System - Technical Requirements
## 1. Packages
Organize the codebase using Java packages for better modularity and maintainability. The suggested package structure is:
- `bank.models`
    - Contains core classes like `Account`, `Transaction`, and `User`.
    - Defines the structure of the main entities in the system.
- `bank.services`
    - Implements the core banking operations such as deposits, withdrawals, fund transfers, and account management.
    - Contains business logic and enforces transaction rules.
- `bank.utils`
    - Utility classes for common functionalities such as input validation, formatting, and generating unique account numbers.
    - Helps maintain clean and reusable code.
- `bank.main`
    - Contains the main entry point of the application.
    - Initializes the system and handles user interactions.
---
## 2. Encapsulation
Implement encapsulation to safeguard sensitive data and ensure secure access and modification.
- **Private Fields:**
    - Attributes such as `accountNumber`, `accountHolder`, `balance`, and `transactionHistory` must be declared as private.
    - This prevents unauthorized access and modification from outside the class.
- **Public Getters and Setters:**
    - Provide public methods to access and modify private fields securely.
    - Include necessary validations in setters to maintain data integrity.
- **Transaction Security:**
    - Internal validation methods should be private and handle checks for sufficient balance, valid account numbers, and transaction limits.
    - Ensure atomic operations for fund transfers to avoid inconsistencies.
- **Data Integrity:**
    - Protect against negative deposits or withdrawals.
    - Automatically update transaction history after every successful operation.
---
## 3. Data Persistence (Optional Enhancement)
- Use file handling or a simple database (like SQLite) for storing user accounts and transaction history.
- Implement basic CRUD operations for persistent data management.
---
## 4. Error Handling and Validation
- Implement robust error handling using `try-catch` blocks for runtime exceptions.
- Validate user inputs, ensuring non-negative amounts and valid account information.
---
## 5. User Interface (CLI-Based)
- Develop a command-line interface (CLI) for basic user interactions.
- Options should include creating accounts, viewing balances, depositing funds, withdrawing funds, and transferring money.
- Admin panel for viewing all user accounts and transaction logs.

# Online Banking System - Technical Requirements

## 1. Packages
Organize the codebase using Java packages for better modularity and maintainability. The suggested package structure is:

### bank.models
Contains core classes like `Account`, `Transaction`, and `User`. Defines the structure of the main entities in the system.

#### Account
- **Fields:**
    - `private String accountNumber`
    - `private String accountHolder`
    - `private double balance`
    - `private List<Transaction> transactionHistory`
- **Methods:**
    - `public String getAccountNumber()`
    - `public String getAccountHolder()`
    - `public double getBalance()`
    - `public List<Transaction> getTransactionHistory()`
    - `public void deposit(double amount)`
    - `public void withdraw(double amount)`
    - `public void addTransaction(Transaction transaction)`

#### Transaction
- **Fields:**
    - `private String transactionId`
    - `private String accountNumber`
    - `private double amount`
    - `private Date date`
    - `private String type` (e.g., "deposit", "withdrawal", "transfer")
- **Methods:**
    - `public String getTransactionId()`
    - `public String getAccountNumber()`
    - `public double getAmount()`
    - `public Date getDate()`
    - `public String getType()`

#### User
- **Fields:**
    - `private String userId`
    - `private String name`
    - `private String email`
    - `private List<Account> accounts`
- **Methods:**
    - `public String getUserId()`
    - `public String getName()`
    - `public String getEmail()`
    - `public List<Account> getAccounts()`
    - `public void addAccount(Account account)`

### bank.services
Implements the core banking operations such as deposits, withdrawals, fund transfers, and account management. Contains business logic and enforces transaction rules.

#### AccountService
- **Methods:**
    - `public void createAccount(User user, String accountHolder)`
    - `public void deposit(String accountNumber, double amount)`
    - `public void withdraw(String accountNumber, double amount)`
    - `public void transfer(String fromAccountNumber, String toAccountNumber, double amount)`
    - `private boolean validateAccount(String accountNumber)`
    - `private boolean checkSufficientBalance(String accountNumber, double amount)`

### bank.utils
Utility classes for common functionalities such as input validation, formatting, and generating unique account numbers. Helps maintain clean and reusable code.

#### Utils
- **Methods:**
    - `public static String generateUniqueAccountNumber()`
    - `public static boolean validateEmail(String email)`
    - `public static boolean validateAmount(double amount)`

### bank.main
Contains the main entry point of the application. Initializes the system and handles user interactions.

#### Main
- **Methods:**
    - `public static void main(String[] args)`
    - `private static void showMenu()`
    - `private static void handleUserInput()`

## 2. Encapsulation
Implement encapsulation to safeguard sensitive data and ensure secure access and modification.

### Private Fields
Attributes such as `accountNumber`, `accountHolder`, `balance`, and `transactionHistory` must be declared as private. This prevents unauthorized access and modification from outside the class.

### Public Getters and Setters
Provide public methods to access and modify private fields securely. Include necessary validations in setters to maintain data integrity.

### Transaction Security
Internal validation methods should be private and handle checks for sufficient balance, valid account numbers, and transaction limits. Ensure atomic operations for fund transfers to avoid inconsistencies.

### Data Integrity
Protect against negative deposits or withdrawals. Automatically update transaction history after every successful operation.

## 3. Data Persistence (Optional Enhancement)
Use file handling or a simple database (like SQLite) for storing user accounts and transaction history. Implement basic CRUD operations for persistent data management.

## 4. Error Handling and Validation
Implement robust error handling using try-catch blocks for runtime exceptions. Validate user inputs, ensuring non-negative amounts and valid account information.

## 5. User Interface (CLI-Based)
Develop a command-line interface (CLI) for basic user interactions. Options should include creating accounts, viewing balances, depositing funds, withdrawing funds, and transferring money. Admin panel for viewing all user accounts and transaction logs.