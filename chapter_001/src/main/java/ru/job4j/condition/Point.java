package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Point {
    /*
     * Это поле объекта. Онон доступно только конкретному объекту.
     */
    private int x;
    /*
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;
    /*
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int z;
    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public  void info() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }
    public double distance3d(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }
}