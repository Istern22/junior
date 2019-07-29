package ru.job4j.paint;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square implements Shape {
    @Override
    public String draw() {
       StringBuilder pic = new StringBuilder();
       pic.append("xxxx");
       pic.append(System.lineSeparator());
       pic.append("x  x");
       pic.append(System.lineSeparator());
       pic.append("xxxx");
        pic.append(System.lineSeparator());
       return pic.toString();
    }
}
