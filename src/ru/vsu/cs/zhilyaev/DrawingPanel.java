package ru.vsu.cs.zhilyaev;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


class DrawingPanel extends JFrame {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 800;

    public DrawingPanel() {
        setTitle(" Drawing panel ");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        Point p1 = new Point(100, 250, 152, 251, 152);
        Point p2 = new Point(250, 100, 0, 128, 255);
        Point p3 = new Point(400, 250, 253, 106, 2);
        Triangle triangle = new Triangle(p1, p2, p3);

        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, triangle.getColor(x, y));
            }
        }
        g2d.drawImage(image, null, 50, 50);
    }
}