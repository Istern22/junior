package ru.job4j.paint;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   x   ");
        pic.append(System.lineSeparator());
        pic.append("  xxx  ");
        pic.append(System.lineSeparator());
        pic.append(" xxxxx ");
        pic.append(System.lineSeparator());
        pic.append("xxxxxxx");
        pic.append(System.lineSeparator());
        return pic.toString();
    }
}
