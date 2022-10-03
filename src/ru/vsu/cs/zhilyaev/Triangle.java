package ru.vsu.cs.zhilyaev;

import java.awt.*;

public class Triangle {
    private Point[] points = new Point[3];

    public Triangle (Point p1, Point p2, Point p3) {
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
    }

    public int getColor(int x, int y) {;
        double l1 = (((points[1].getY() - points[2].getY()) * ((double) x - points[2].getX())) + ((points[2].getX() - points[1].getX()) * ((double) y - points[2].getY()))) /
                (((points[1].getY()) - points[2].getY()) * ((points[0].getX() - points[2].getX())) + ((points[2].getX() - points[1].getX()) * (points[0].getY() - points[2].getY())));
        double l2 = (((points[2].getY() - points[0].getY()) * ((double) x - points[2].getX())) + ((points[0].getX() - points[2].getX()) * ((double) y - points[2].getY()))) /
                (((points[1].getY()) - points[2].getY()) * ((points[0].getX() - points[2].getX())) + ((points[2].getX() - points[1].getX()) * (points[0].getY() - points[2].getY())));
        double l3 = 1 - l1 - l2;

        int pixelValue = Color.WHITE.getRGB();

        if (l1 >= 0 && l1 <= 1 && l2 >= 0 && l2 <= 1 && l3 >= 0 && l3 <= 1) {
            int r = makeColor((int)(points[0].getColor().getRed() * l2), (int)(points[0].getColor().getGreen() * l2), (int)(points[0].getColor().getBlue() * l2)).getRGB();
            int g = makeColor((int)(points[1].getColor().getRed() * l1), (int)(points[1].getColor().getGreen() * l1), (int)(points[1].getColor().getBlue() * l1)).getRGB();
            int b = makeColor((int)(points[2].getColor().getRed() * l3), (int)(points[2].getColor().getGreen() * l3), (int)(points[2].getColor().getBlue() * l3)).getRGB();

            pixelValue = r + g + b;
        }
        return pixelValue;
    }

    private Color makeColor(int r, int g, int b) {
        return new Color(r, g, b);
    }

    /*
    long pixelValue = Color.WHITE.getRGB();
        double l1 = (((points[1].getY() - points[2].getY()) * ((double) x * points[2].getX())) + ((points[2].getX() - points[1].getX()) * ((double) y - points[2].getY()))) /
                (((points[1].getY()) - points[2].getY()) * ((points[0].getX() - points[2].getX())) + ((points[2].getX() - points[1].getX()) * (points[0].getY() - points[2].getY())));
        double l2 = (((points[2].getY() - points[0].getY()) * ((double) x * points[2].getX())) + ((points[0].getX() - points[2].getX()) * ((double) y - points[2].getY()))) /
                (((points[1].getY()) - points[2].getY()) * ((points[0].getX() - points[2].getX())) + ((points[2].getX() - points[1].getX()) * (points[0].getY() - points[2].getY())));
        double l3 = 1 - l1 - l2;

        if (l1 >= 0 && l1 <= 1 && l2 >= 0 && l2 <= 1 && l3 >= 0 && l3 <= 1) {
            pixelValue = (int) (points[0].getR() * l1 + points[0].getG() * l2 + points[0].getB() * l3 + points[1].getR() * l1 + points[1].getG() * l2 + points[1].getB() * l3 +
                    points[2].getR() * l1 + points[2].getG() * l2 + points[2].getB() * l3);
        }

        return (int) pixelValue;
     */

    /*
     pixelValue = 0xFF000000 +
                        ((long) (l1 * ((points[i].getR() & 0x00FF0000) >> 16) + l2 * ((points[i].getG() & 0x00FF0000) >> 16) + l3 * ((points[i].getB() & 0x00FF0000) >> 16)) << 16) +
                        ((long)(l1 * ((points[i].getR() & 0x0000FF00) >> 8) + l2 * ((points[i].getG() & 0x0000FF00) >> 8) + l3 * ((points[i].getB() & 0x0000FF00) >> 8)) << 8) +
                        (long)(l1 * (points[i].getR() & 0x000000FF) + l2 * (points[i].getG() & 0x000000FF) + l3 * (points[i].getB() & 0x000000FF));
     */
}
