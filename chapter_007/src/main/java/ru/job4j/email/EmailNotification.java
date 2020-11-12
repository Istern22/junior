package ru.job4j.email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        String subject = "Notification " + user.getName() + " to email " +  user.getEmail();
        String body = "Add a new event to " + user.getName();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                send(subject, body, user.getEmail());
            }
        });
    }

    public void close() {
        pool.shutdown();
    }

    public void send(String subject, String body, String email) {

    }

    public static void main(String[] args) {
        EmailNotification email = new EmailNotification();
        email.emailTo(new User("anna", "anna@mail.ru"));
        email.close();
    }
}
