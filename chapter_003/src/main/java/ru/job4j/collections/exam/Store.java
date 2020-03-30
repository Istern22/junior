package ru.job4j.collections.exam;

import java.util.*;

public class Store {

    public Map<User, HashSet<String>> merge(Map<User, HashSet<String>> map) {
        var emailMap = new HashMap<String, User>();
        var result = new HashMap<User, HashSet<String>>();
        var it = map.entrySet().iterator();
        while (it.hasNext()) {
            var item = it.next();
            var emails = item.getValue();
            var key = item.getKey();
            for (var temp : emails) {
                if (emailMap.containsKey(temp)) {
                    key = emailMap.get(temp);
                    break;
                }
            }
            for (var email : emails) {
                emailMap.put(email, key);
                if (!result.containsKey(key)) {
                    result.put(key, new HashSet<>(Arrays.asList(email)));
                } else  {
                    result.get(key).add(email);
                }
            }
        }
        return result;
    }
}
