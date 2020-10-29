package ru.job4j.parser;

import java.io.*;
import java.util.function.Predicate;

public class ParserFile {

    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent(Predicate<Integer> pred) {
        StringBuilder output = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) != -1) {
                if (pred.test(data)) {
                    output.append((char) data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        ParserFile parser = new ParserFile();
        parser.setFile(new File("E:\\Светлана Рагулина\\COCA-COLA_WRK\\Desktop\\read.txt"));
        System.out.println(parser.getContent(data -> true));
        System.out.println(parser.getContent(data -> data < 0x80));
        SaveFile save = new SaveFile();
        save.setFile(new File("E:\\Светлана Рагулина\\COCA-COLA_WRK\\Desktop\\test.txt"));
        save.saveContent("test");
    }
}
