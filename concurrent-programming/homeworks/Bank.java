public class Bank {
    private long[] balances;
    private Object[] locks;

    public Bank(int accountCount, long initialBalance) {
        if (accountCount < 1 || initialBalance < 0) {
            throw new IllegalArgumentException(
                    "invalid arguments: accountCount=" + accountCount + ", initialBalance=" + initialBalance);
        }
        balances = new long[accountCount];
        locks = new Object[accountCount];
        for (int i = 0; i < accountCount; i++) {
            balances[i] = initialBalance;
            locks[i] = new Object();
        }
    }

    public boolean transfer(int from, int to, long amount) {
        checkIndex(from);
        checkIndex(to);
        if (from == to) {
            throw new IllegalArgumentException("from and to must differ: " + from);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive: " + amount);
        }

        int first = Math.min(from, to);
        int second = Math.max(from, to);
        synchronized (locks[first]) {
            synchronized (locks[second]) {
                if (balances[from] < amount) {
                    return false;
                }
                balances[from] -= amount;
                balances[to] += amount;
                return true;
            }
        }
    }

    public long balance(int account) {
        checkIndex(account);
        synchronized (locks[account]) {
            return balances[account];
        }
    }

    public long totalBalance() {
        return sumFrom(0);
    }

    private long sumFrom(int i) {
        if (i == balances.length) {
            return 0;
        }
        synchronized (locks[i]) {
            return balances[i] + sumFrom(i + 1);
        }
    }

    private void checkIndex(int account) {
        if (account < 0 || account >= balances.length) {
            throw new IllegalArgumentException("invalid account index: " + account);
        }
    }
}
