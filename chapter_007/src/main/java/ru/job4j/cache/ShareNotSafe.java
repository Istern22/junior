package ru.job4j.cache;

public class ShareNotSafe {
    public static void main(String[] args) throws InterruptedException {
        UserCache cache = new UserCache();
        User user = User.of("name");
        cache.add(user);
        cache.add(User.of("name1"));
        Thread first = new Thread(
                () -> {
                    user.setName("rename");
                }
        );
        first.start();
        first.join();
        System.out.println(cache.findById(1).getName());
        for (var item : cache.findAll()) {
            System.out.println(item.getName());
        }
    }
}
