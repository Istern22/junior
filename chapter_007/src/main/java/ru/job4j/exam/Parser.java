package ru.job4j.exam;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parser {

    private static ConcurrentHashMap<Integer, Camera> map = new ConcurrentHashMap<>();

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void parse(String data) throws MalformedURLException {
        JSONArray jsonArr = new JSONArray(data);
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    doCamera(jsonObj);
                }
            });
        }
        pool.shutdown();
    }

    public JSONObject getData(URL url) {
        String data = read(url);
        return new JSONObject(data);
    }

    public void doCamera(JSONObject jsonObj) {
        int id = jsonObj.getInt("id");
        try {
            JSONObject sourceDataUrl = getData(new URL(jsonObj.getString("sourceDataUrl")));
            JSONObject tokenDataUrl = getData(new URL(jsonObj.getString("tokenDataUrl")));
            String urlType = sourceDataUrl.getString("urlType");
            String videoUrl = sourceDataUrl.getString("videoUrl");
            String value = tokenDataUrl.getString("value");
            int ttl = tokenDataUrl.getInt("ttl");
            Camera camera = new Camera(id, urlType, videoUrl, value, ttl);
            map.put(id, camera);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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

    public static void printMap() {
        for (int key : map.keySet()) {
            System.out.println(map.get(key).toString());
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        Parser parser = new Parser();
        URL url = new URL("http://www.mocky.io/v2/5c51b9dd3400003252129fb5");
        String data = parser.read(url);
        parser.parse(data);
        printMap();
    }
}
