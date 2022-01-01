package renderer.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import renderer.point.MyPoint;
import renderer.point.PointConverter;
import renderer.Display;

public class MyPolygon {

    private String id;
    private Color color;
    private MyPoint[] points;

    public MyPolygon(String id, Color color, MyPoint... points) {
        this.id = id;
        this.color = color;
        this.points = new MyPoint[points.length];
        for (int i = 0; i < points.length; i++) {
            MyPoint p = points[i];
            this.points[i] = new MyPoint(p.x, p.y, p.z);
        }
    }

    public MyPolygon(String id, MyPoint... points) {
        this.id = id;
        this.color = Color.white;
        this.points = new MyPoint[points.length];
        for (int i = 0; i < points.length; i++) {
            MyPoint p = points[i];
            this.points[i] = new MyPoint(p.x, p.y, p.z);
        }
    }

    public double getAverageX() {
        double sum = 0;
        for (MyPoint p : this.points) {
            sum += p.x;
        }
        return sum / this.points.length;
    }

    public double getAverageY() {
        double sum = 0;
        for (MyPoint p : this.points) {
            sum += p.y;
        }
        return sum / this.points.length;
    }

    public double getAverageZ() {
        double sum = 0;
        for (MyPoint p : this.points) {
            sum += p.z;
        }
        return sum / this.points.length;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void render(Graphics g) {
        Polygon poly = new Polygon();
        for (int i = 0; i < this.points.length; i++) {
            Point p = PointConverter.convertPoint(points[i]);
            poly.addPoint(p.x, p.y);
        }
        g.setColor(this.color);
        g.fillPolygon(poly);
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        for (MyPoint p : points) {
            PointConverter.rotateAxisX(p, CW, xDegrees);
            PointConverter.rotateAxisY(p, CW, yDegrees);
            PointConverter.rotateAxisZ(p, CW, zDegrees);
        }
    }

    public double distanceFromCamera(int mouseX, int mouseY, int depth) {
        double mouseXConverted = (mouseX - Display.WIDTH/2);
        double mouseYConverted = -1 * (mouseY - Display.HEIGHT/2);
        MyPoint camera = new MyPoint(depth, mouseXConverted, mouseYConverted);
        MyPoint center = new MyPoint(this.getAverageX(), this.getAverageY(), this.getAverageZ());

        double xDif = camera.x - center.x;
        double yDif = camera.y - center.y;
        double zDif = camera.z - center.z;
        return Math.sqrt(xDif*xDif + yDif*yDif + zDif*zDif);
    }

}
