package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryUsage {
    private static final Logger LOG = LoggerFactory.getLogger(MemoryUsage.class);

    public static class User {
        public String name;
        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + '}';
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(String.format("destroy object user %s", this));
        }

        public static void main(String[] args) {
            info();
            System.out.println("start");
            for (int i = 0; i < 10000; i++) {
                new User("name" + i);
            }
            System.out.println("finish");
            info();
        }

        public static void info() {
            double mb = 1024 * 1024;
            Runtime runtime = Runtime.getRuntime();
            System.out.println("-------Usage memory-------");
            System.out.printf("Total memory %.4f%n", runtime.totalMemory() / mb);
            System.out.printf("Free memory %.4f%n", runtime.freeMemory() / mb);
            System.out.printf("Used memory %.4f%n", (runtime.totalMemory() - runtime.freeMemory()) / mb);
            System.out.printf("Max memory %.4f%n", runtime.maxMemory() / mb);
        }

    }
}