public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread download = new Thread(() -> {
            System.out.println("Start downloading...");

            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(
                        Thread.currentThread().getName() + ": step " + i
                    );

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "download");

        Thread music = new Thread(() -> {
            System.out.println("Start music...");
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                    Thread.currentThread().getName() + ": step " + i
                );
            }
        }, "music");

        download.start();
        music.start();

        download.join();
        music.join(); // music does not wait for download
        
        System.out.println("All workers finished");
    }
}
