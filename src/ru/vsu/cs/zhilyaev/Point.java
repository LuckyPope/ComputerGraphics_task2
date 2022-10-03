package ru.vsu.cs.zhilyaev;

import java.awt.*;

public class Point {
    private final double[] coordinates = new double[2];
    private final Color color;

    public Point(double x, double y, int r, int g, int b) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.color = new Color(r, g , b);
    }

    public double getX() {
        return coordinates[0];
    }

    public double getY() {
        return coordinates[1];
    }

    public Color getColor() {
        return color;
    }
}
