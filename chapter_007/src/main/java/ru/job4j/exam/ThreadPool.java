package ru.job4j.exam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

public class ThreadPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPool.class);
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    private static ConcurrentHashMap<Integer, Camera> futures = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        String data = parser.read(new URL("http://www.mocky.io/v2/5c51b9dd3400003252129fb5"));
        JSONArray jsonArr = new JSONArray(data);
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            int id = jsonObj.getInt("id");
            Future<Camera> task = EXECUTOR_SERVICE.submit(
                    new Callable<Camera>() {
                        @Override
                        public Camera call() throws Exception {
                            int id = jsonObj.getInt("id");
                            Camera result = null;
                            try {
                                JSONObject sourceDataUrl = parser.getData(new URL(jsonObj.getString("sourceDataUrl")));
                                JSONObject tokenDataUrl = parser.getData(new URL(jsonObj.getString("tokenDataUrl")));
                                String urlType = sourceDataUrl.getString("urlType");
                                String videoUrl = sourceDataUrl.getString("videoUrl");
                                String value = tokenDataUrl.getString("value");
                                int ttl = tokenDataUrl.getInt("ttl");
                                result = new Camera(id, urlType, videoUrl, value, ttl);
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            return result;
                        }
                    }
            );
            try {
                System.out.println(task.get());
            } catch (Exception e) {
                LOGGER.error("Exception " + e);
            }
        }
        EXECUTOR_SERVICE.shutdown();
    }
}
