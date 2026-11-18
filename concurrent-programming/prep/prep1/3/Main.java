public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread download = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(
                        Thread.currentThread().getName() + ": step " + i
                    );
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "download");


        Thread music = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                    Thread.currentThread().getName() + ": step " + i
                );
            }
        }, "music");


        download.start();
        music.start();

        download.join();
        music.join();

        System.out.println("Session complete");
    }
}
