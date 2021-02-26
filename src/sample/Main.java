package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        JFrame window = new JFrame("Art");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyCanvas canvas = new MyCanvas();
        window.add(canvas);

        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}

class MyCanvas extends JPanel {

    // constructor for canvas
    public MyCanvas() {
        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Paintbrush myBrush = new Paintbrush(g);
        myBrush.createSky();
        myBrush.createGrass();
        myBrush.createMountains();
        myBrush.createTrees(new Color(73, 66, 55), new Color(28, 52, 15), 50, 30, 30, 300);
        myBrush.createTrees(new Color(85, 69, 49), new Color(76, 116, 53), 48, 38, 15, 320);
        myBrush.createTrees(new Color(85, 69, 49), new Color(72, 142, 35), 100, 3, 700, 450);
        myBrush.createTrees(new Color(128, 87, 39), new Color(93, 165, 52), 180, 1, 80, 525);
        myBrush.createTrees(new Color(80, 52, 19), new Color(38, 71, 17), 135, 1, 115, 545);

    }

    class Paintbrush {
        private Graphics g;

        public Paintbrush(Graphics graphics) {
            this.g = graphics;
        }

        public void createSky() {
            // paint sky
            g.setColor(new Color(96, 204, 253));
            g.fillRect(0, 0, 900, 300);

            // paint sun
            g.setColor(Color.YELLOW);
            g.fillOval(680, 30, 60, 60);
        }

        public void createMountains() {

            // paint blue
            g.setColor(new Color(8, 87, 101));
            Polygon blueMountain = new Polygon();
            blueMountain.addPoint(0, 300); // bottom left
            blueMountain.addPoint(0, 200); // top left
            blueMountain.addPoint(100, 130); // top
            blueMountain.addPoint(550, 300); // bottom-right
            g.fillPolygon(blueMountain);

            // paint brown mountain
            g.setColor(new Color(47, 44, 44));
            Polygon triangle = new Polygon();
            triangle.addPoint(0, 300); // bottom left
            triangle.addPoint(310, 60); // top
            triangle.addPoint(550, 300); // bottom-right
            g.fillPolygon(triangle);

            // paint green mountain
            g.setColor(new Color(59, 82, 77));
            Polygon twoPicks = new Polygon();
            twoPicks.addPoint(300, 300); // bottom left
            twoPicks.addPoint(450, 120); // pick 1 top
            twoPicks.addPoint(560, 230); // middle point between two picks
            twoPicks.addPoint(700, 130); // pick 2 top
            twoPicks.addPoint(900, 300); // bottom right
            g.fillPolygon(twoPicks);
        }

        public void createTrees(Color trunkColor, Color leavesColor, int height, int quantity, int xPoint, int yPoint) {
            int squire = height/7;

            for (int i = 0; i < quantity; i++) {
            Polygon trunk = new Polygon();
                // create a trunk
                g.setColor(trunkColor);
                trunk.addPoint(xPoint, yPoint); // left bottom point
                trunk.addPoint(xPoint, yPoint - (3 * squire)); // left top point
                trunk.addPoint(xPoint + squire, yPoint - (3 * squire)); // right top point
                trunk.addPoint(xPoint + squire, yPoint); // right bottom point
                g.fillPolygon(trunk);

                // create leaves
                g.setColor(leavesColor);
                g.fillOval(xPoint-squire, yPoint - height, 3 * squire, 5 * squire);

                // change x and y positions
                xPoint += 4 * squire;
            }


        }

        public void createGrass(){
            GradientPaint gradientPaint =  new GradientPaint(0, 0, new Color(26, 47, 10), 0, 900, new Color(67, 146, 72));
            Graphics2D g2 =  (Graphics2D) g;
            g2.setPaint(gradientPaint);
            g.fillRect(0, 250, 900, 350);

        }

    }
}