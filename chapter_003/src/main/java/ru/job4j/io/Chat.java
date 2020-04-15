package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {

    public List<String> phrases = new ArrayList<String>();
    public List<String> log = new ArrayList<String>();

    public void getPhrases(String directory) throws IOException {
        Files.lines(Paths.get(directory)).forEach(phrases::add);
    }

    public void answer() {
        var answer = phrases.get((int) (Math.random() * phrases.size()));
        System.out.println(answer);
        log.add(answer);
    }

    public void chatting() {
        var in = new Scanner(System.in);
        var hello = "Привет. Напишите что-нибудь.";
        System.out.println(hello);
        log.add(hello);
        /*while (!(input = in.nextLine()).toLowerCase().contains("закончить")) {
            log.add(input);
            if (input.toLowerCase().contains("стоп")) {
                String inner;
                while (!(inner = in.nextLine()).toLowerCase().contains("продолжить")) {
                    log.add(inner);
                }
                log.add(inner);
            }
            answer();
        }*/
        while (in.hasNextLine()) {
            String input = in.nextLine();
            if (input.toLowerCase().contains("закончить")) {
                log.add("Закончить.");
                break;
            }
            log.add(input);
            if (input.toLowerCase().contains("стоп")) {
                String inner = in.nextLine();
                while (!inner.toLowerCase().contains("продолжить")) {
                    inner = in.nextLine();
                    log.add(inner);
                }
                log.add(inner);
            }
            answer();
        }
    }

    public static void main(String[] args) throws IOException {
        var chat = new Chat();
        chat.getPhrases("C:\\projects\\junior\\chapter_003\\answers.txt");
        chat.chatting();
        chat.log.stream().forEach(System.out::println);
    }
}
