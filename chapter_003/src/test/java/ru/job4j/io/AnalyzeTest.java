package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenOnePeriod() throws IOException {
        var analyze = new Analyze();
        var source = folder.newFile("source1.csv");
        var target = folder.newFile("result1.csv");
        var list = List.of(
                "200 12:17:00",
                "300 12:17:02",
                "400 12:18:00",
                "500 12:19:00",
                "400 12:20:00",
                "300 12:21:00");
        Files.write(source.toPath(), list, Charset.defaultCharset());
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        var result = Files.readAllLines(target.toPath());
        assertThat(result.get(0), is("12:18:00;12:21:00"));
    }

    @Test
    public void whenTwoPeriods() throws IOException {
        var analyze = new Analyze();
        var source = folder.newFile("source2.csv");
        var target = folder.newFile("result2.csv");
        var list = List.of(
                "400 12:18:00",
                "500 12:19:00",
                "400 12:20:00",
                "300 12:21:00",
                "500 12:27:00",
                "300 12:27:02");
        Files.write(source.toPath(), list, Charset.defaultCharset());
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        var result = Files.readAllLines(target.toPath());
        assertThat(result.get(0), is("12:18:00;12:21:00"));
        assertThat(result.get(1), is("12:27:00;12:27:02"));
    }

    @Test
    public void whenNoPeriods() throws IOException {
        var analyze = new Analyze();
        var source = folder.newFile("source3.csv");
        var target = folder.newFile("result3.csv");
        var list = List.of(
                "300 12:20:00",
                "300 12:21:00",
                "200 12:27:00",
                "300 12:27:02");
        Files.write(source.toPath(), list, Charset.defaultCharset());
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        var result = Files.readAllLines(target.toPath());
        assertThat(result, is(new ArrayList<>()));
    }
}