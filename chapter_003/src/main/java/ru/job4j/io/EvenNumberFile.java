package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (var in = new FileInputStream("even.txt")) {
            var text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            var lines = text.toString().split(System.lineSeparator());
            for (var line : lines) {
                if (Integer.parseInt(line) % 2 == 0) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
