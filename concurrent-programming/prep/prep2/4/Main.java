class DownloadTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[1] Downloading chunk " + i);
        }
    }
}

class DownloadThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Downloading chunk " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DownloadTask task = new DownloadTask();
        Thread download = new Thread(task);

        download.start();
        download.join();
    }
}
