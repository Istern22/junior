package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void whenOnePeriod() {
        var analyze = new Analyze();
        var source = "./src/main/java/ru/job4j/io/source1.csv";
        var target = "./src/main/java/ru/job4j/io/result1.csv";
        try (var out = new PrintWriter(new FileOutputStream(source))) {
            out.println("200 12:17:00");
            out.println("300 12:17:02");
            out.println("400 12:18:00");
            out.println("500 12:19:00");
            out.println("400 12:20:00");
            out.println("300 12:21:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        analyze.unavailable(source, target);
        var result = new ArrayList<String>();
        try (var read = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = read.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        assertThat(result.get(0), is("12:18:00;12:21:00"));
    }

    @Test
    public void whenTwoPeriods() {
        var analyze = new Analyze();
        var source = "./src/main/java/ru/job4j/io/source2.csv";
        var target = "./src/main/java/ru/job4j/io/result2.csv";
        try (var out = new PrintWriter(new FileOutputStream(source))) {
            out.println("400 12:18:00");
            out.println("500 12:19:00");
            out.println("400 12:20:00");
            out.println("300 12:21:00");
            out.println("500 12:27:00");
            out.println("300 12:27:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        analyze.unavailable(source, target);
        var result = new ArrayList<String>();
        try (var read = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = read.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result.get(0), is("12:18:00;12:21:00"));
        assertThat(result.get(1), is("12:27:00;12:27:02"));
    }

    @Test
    public void whenNoPeriods() {
        var analyze = new Analyze();
        var source = "./src/main/java/ru/job4j/io/source3.csv";
        var target = "./src/main/java/ru/job4j/io/result3.csv";
        try (var out = new PrintWriter(new FileOutputStream(source))) {
            out.println("300 12:20:00");
            out.println("300 12:21:00");
            out.println("200 12:27:00");
            out.println("300 12:27:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        analyze.unavailable(source, target);
        var result = new ArrayList<String>();
        try (var read = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = read.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result, is(new ArrayList<>()));
    }
}