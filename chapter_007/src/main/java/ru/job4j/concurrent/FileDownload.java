package ru.job4j.concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {
    private String url;
    private int speed;

    public FileDownload(String[] args) {
        this.url = args[0];
        this.speed = Integer.parseInt(args[1]);
    }

    public void download() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(getFileName())) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            int stop = stop();
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(stop);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        String[] array = url.split("/");
        return array[array.length - 1];
    }

    /**
     * Метод определяет реальную скорость загрузки файла
     * Загружаем 1024 байт, смотрим, сколько миллисекунд это заняло.
     * @return скорость, килобайт в секунду
     */
    public int realSpeed() {
        int result = 0;
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
            byte[] data = new byte[1024];
            long start = System.currentTimeMillis();
            while (in.read(data, 0, 1024) != -1) {
                System.currentTimeMillis();
            }
            result = (int) (1024 / (System.currentTimeMillis() - start) * 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result / 1000;
    }

    /**
     * Метод сравнивает реальную и заданную скорость
     * Определяет, какая задержка должна быть, чтобы скачивать с заданной скоростью
     * @return
     */
    public int stop() {
        int realSpeed = realSpeed();
        int difference = realSpeed - speed;
        double sec = (double) difference / realSpeed;
        return (int) (sec * 1000);
    }

    public static void main(String[] args) {
        FileDownload fileDownload = new FileDownload(args);
        System.out.println(fileDownload.realSpeed());
        System.out.println(fileDownload.stop());
        fileDownload.download();
    }
}
