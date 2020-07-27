package ru.job4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Svetlana";
        int age = 28;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte item0 = 127;
        short item1 = 32767;
        int item2 = 0;
        long item3 = -13400;
        char item4 = 'l';
        boolean item5 = false;
        float item6 = 3.14f;
        double item7 = 0.006;
        LOG.debug("Types : byte {}, short {}, int {}, long {}, char {}, boolean {}, float {}, double {}",
                item0, item1, item2, item3, item4, item5, item6, item7);
    }
}
