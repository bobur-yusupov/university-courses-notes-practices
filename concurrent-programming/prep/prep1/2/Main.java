public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread download = new Thread(() -> {
            System.out.println("Start downloading...");
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                    Thread.currentThread().getName() + ": step " + i
                );
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

        download.join(); // music does not wait 
        music.join();
        
        System.out.println("All workers finished");
    }
}
