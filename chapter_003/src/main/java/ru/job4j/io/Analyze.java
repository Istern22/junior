package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analyze {

    private List<String> available = List.of("200", "300");
    private List<String> notAvailable = List.of("400", "500");

    public void unavailable(String source, String target) {
        write(analyze(read(source)), target);
    }

    public List<String> analyze(List<String> list) {
        var result = new ArrayList<String>();
        String temp = null;
        for (var data : list) {
            var items = data.split(" ");
            if (temp == null && notAvailable.contains(items[0])) {
                temp = items[1];
            } else if (temp != null && available.contains(items[0])) {
                result.add(temp + ";" + items[1]);
                temp = null;
            }
        }
        return result;
    }

    public List<String> read(String source) {
        var result = new ArrayList<String>();
        try (var read = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = read.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void write(List<String> list, String target) {
        try (var out = new PrintWriter(new FileOutputStream(target))) {
            for (var item : list) {
                out.println(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (var out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
