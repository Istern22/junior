package ru.job4j.exam;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parser {

    public JSONObject getData(URL url) {
        String data = read(url);
        return new JSONObject(data);
    }

    public String read(URL url) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            StringBuffer data = new StringBuffer();
            while ((line = in.readLine()) != null) {
                data.append(line);
            }
            return data.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
