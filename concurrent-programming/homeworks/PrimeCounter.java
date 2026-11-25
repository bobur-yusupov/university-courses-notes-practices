public class PrimeCounter {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; d <= n / d; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes(int from, int to, int threadCount) throws InterruptedException {
        if (from < 0 || to < from || threadCount < 1) {
            throw new IllegalArgumentException(
                    "invalid arguments: from=" + from + ", to=" + to + ", threadCount=" + threadCount);
        }

        long length = (long) to - from + 1;
        int[] counts = new int[threadCount];
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            final long start = from + i * length / threadCount;
            final long end = from + (i + 1) * length / threadCount;
            threads[i] = new Thread(() -> {
                int count = 0;
                for (long n = start; n < end; n++) {
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    if (isPrime((int) n)) {
                        count++;
                    }
                }
                counts[index] = count;
            }, "PrimeCounter-worker-" + i);
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            for (Thread t : threads) {
                t.interrupt();
            }
            throw e;
        }

        int total = 0;
        for (int c : counts) {
            total += c;
        }
        return total;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(countPrimes(1, 100, 3));
        System.out.println(countPrimes(0, 6_000_000, 4));
    }
}
