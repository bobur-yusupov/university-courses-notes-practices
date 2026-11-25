import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class PinCracker {
    public static String sha256Hex(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String crack(String hash) {
        if (hash == null || !hash.matches("[0-9a-f]{64}")) {
            throw new IllegalArgumentException("not a SHA-256 hex hash: " + hash);
        }
        for (int pin = 0; pin <= 99_999; pin++) {
            String candidate = String.format("%05d", pin);
            if (sha256Hex(candidate).equals(hash)) {
                return candidate;
            }
        }
        return null;
    }

    public static List<String> crackAll(List<String> hashes, int poolSize) throws InterruptedException, ExecutionException {
        if (hashes == null || poolSize < 1) {
            throw new IllegalArgumentException("invalid arguments: hashes=" + hashes + ", poolSize=" + poolSize);
        }

        List<Thread> poolThreads = new ArrayList<>();
        ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        ThreadFactory trackingFactory = runnable -> {
            Thread t = defaultFactory.newThread(runnable);
            synchronized (poolThreads) {
                poolThreads.add(t);
            }
            return t;
        };

        ExecutorService pool = Executors.newFixedThreadPool(poolSize, trackingFactory);
        try {
            List<Future<String>> futures = new ArrayList<>();
            for (String hash : hashes) {
                Callable<String> task = () -> crack(hash);
                futures.add(pool.submit(task));
            }

            List<String> results = new ArrayList<>();
            for (Future<String> future : futures) {
                results.add(future.get());
            }
            return results;
        } finally {
            pool.shutdownNow();
            waitUntilDead(pool, poolThreads);
        }
    }

    private static void waitUntilDead(ExecutorService pool, List<Thread> poolThreads) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                    }
                    List<Thread> threads;
                    synchronized (poolThreads) {
                        threads = new ArrayList<>(poolThreads);
                    }
                    for (Thread t : threads) {
                        t.join();
                    }
                    return;
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> hashes = List.of(sha256Hex("04711"), sha256Hex("31337"), sha256Hex("99999"));
        System.out.println(crackAll(hashes, 2));
    }
}
