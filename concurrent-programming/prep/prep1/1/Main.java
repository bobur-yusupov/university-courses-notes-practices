public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread download = new Thread(() -> {
            System.out.println("Start Downloading...");
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                    Thread.currentThread().getName() + ": step " + i
                );
            }
        }, "download");

        download.start();
        download.join();

        System.out.println("Start Main...");
        for (int i = 1; i <= 5; i++) {
            System.out.println("main: step " + i);
        }

        // download.join();
        System.out.println("Both tasks finished");
    }
}
