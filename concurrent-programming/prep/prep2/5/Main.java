class DownloadFile1 extends Thread {
    public DownloadFile1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i=1; i<=4; i++) {
                System.out.println(
                    Thread.currentThread().getName() + " Downloading chunk " + i
                );
                Thread.sleep(200);
            }

            System.out.println(
                Thread.currentThread().getName() + " finished"
            );
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " cancelled");
            Thread.currentThread().interrupt();
        }
    }
}


class DownloadFile2 implements Runnable {
    @Override
    public void run() {
        try {
            for (int i=1; i<=20; i++) {
                System.out.println(
                    Thread.currentThread().getName() + " Downloading chunk " + i
                );
                Thread.sleep(300);
            }

            System.out.println(
                Thread.currentThread().getName() + " finished"
            );
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " cancelled");
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DownloadFile1 worker1 = new DownloadFile1("file-1");
        Thread worker2 = new Thread(new DownloadFile2(), "file-2");
        Thread worker3 = new Thread("file-3") {
            @Override
            public void run() {
                try {
                    for (int i=1; i<=3; i++) {
                        System.out.println(
                            Thread.currentThread().getName() + " Downloading chunk " + i
                        );
                        Thread.sleep(250);
                    }

                    System.out.println(
                        Thread.currentThread().getName() + " finished"
                    );
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " cancelled");
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i=1; i<=5; i++) {
                        System.out.println(
                            Thread.currentThread().getName() + " Downloading chunk " + i
                        );
                        Thread.sleep(150);
                    }

                    System.out.println(
                        Thread.currentThread().getName() + " finished"
                    );
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " cancelled");
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread worker4 = new Thread(task4, "file-4");

        Thread counter = new Thread(() -> {
            long count = 0;

            while (!Thread.currentThread().isInterrupted()) {
                count++;
            }

            System.out.println(
                Thread.currentThread().getName() + " stopped. Count: " + count
            );
        }, "counter");


        Thread[] workers = {
            worker1, worker2, worker3, worker4, counter
        };

        for (Thread worker : workers) {
            System.out.println(
                "Thread name: " + worker.getName()
                + " | state: " + worker.getState()
                + " | isAlive: " + worker.isAlive()
            );
        }


        // ---------------------------- Start --------------------------------------------------------
        for (Thread worker : workers) {
            worker.start();
        }
        // --------------------------------------------------------------------------------------------

        worker2.join(100);
        System.out.println("Thread name: " + worker2.getName() + " | isAlive: " + worker2.isAlive());

        // ----------------------------- Sleep 1000 ms ------------------------------------------------
        Thread.sleep(1000);

        // ------------------------------ Interrupt ---------------------------------------------------
        worker2.interrupt();
        counter.interrupt();

        // ------------------------------ Join ---------------------------------------------------------
        for (Thread worker : workers) {
            worker.join();
        }

        for (Thread worker : workers) {
            System.out.println(
                "Thread name: " + worker.getName()
                + " | state: " + worker.getState()
                + " | isAlive: " + worker.isAlive()
            );
        }


        System.out.println("All workers stopped");
    }
}
