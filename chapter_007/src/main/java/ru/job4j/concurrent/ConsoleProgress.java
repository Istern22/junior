package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000);
        progress.interrupt();
    }

    @Override
    public void run() {
        String[] process = {"\\", "|", "/"};
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.print("\r Load: " + process[i]);
                if (i == 2) {
                    i = 0;
                } else {
                    i++;
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
