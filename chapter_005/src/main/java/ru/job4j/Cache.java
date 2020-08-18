package ru.job4j;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.WeakHashMap;

public class Cache {

    public static HashMap<SoftReference<String>, String> cache = new HashMap<>();

    public static void main(String[] args) {
        get("address.txt");
        get("email.txt");
        get("name.txt");
    }

    public static String get(String key) {
        String value = cache.get(key);
        if (value == null) {
            try {
                value = Files.readString(Paths.get(".\\chapter_005\\" + key));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File is not found");
            }
            cache.put(new SoftReference<>(key), value);
        }
        return value;
    }
}
