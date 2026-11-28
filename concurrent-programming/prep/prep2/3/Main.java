public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread worker1 = new Thread(() -> {
            System.out.println("Start downloading file-1...\n");
            
            try {
                for (int i = 1; i <= 4; i++) {
                    System.out.println(
                        Thread.currentThread().getName() + ": chunk " + i
                    );
                    Thread.sleep(300);
                }

                System.out.println(
                    Thread.currentThread().getName() + " finished"
                );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "file-1");

        Thread worker2 = new Thread(() -> {
            System.out.println("Start downloading file-2...\n");
            
            try {
                for (int i = 1; i <= 6; i++) {
                    System.out.println(
                        Thread.currentThread().getName() + ": chunk " + i
                    );
                    Thread.sleep(200);
                }

                System.out.println(
                    Thread.currentThread().getName() + " finished"
                );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "file-2");

        Thread worker3 = new Thread(() -> {
            System.out.println("Start downloading file-3...\n");
            
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(
                        Thread.currentThread().getName() + ": chunk " + i
                    );
                    Thread.sleep(500);
                }

                System.out.println(
                    Thread.currentThread().getName() + " finished"
                );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "file-3");

        worker1.start();
        worker2.start();
        worker3.start();

        worker1.join();
        worker2.join();
        worker3.join();

        System.out.println("All downloads complete");
    }
}
