public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread download = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Downloading chunk " + i);
                    Thread.sleep(1000);
                }

                System.out.println("Download complete");
            } catch (InterruptedException e) {
                System.out.println("Download cancelled");
                Thread.currentThread().interrupt();
            }
        }, "download");

        download.start();

        Thread.sleep(2500);
        download.interrupt();

        download.join();
        System.out.println("Main finished");
    }
}
