package renderer.shapes;

import renderer.point.MyPoint;
import renderer.input.ClickType;
import renderer.input.Mouse;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tetrahedron {

    private MyPolygon[] polygons;
    private Color color;

    public Tetrahedron(Color color, MyPolygon... polygons) {
        this.color = color;
        this.polygons = polygons;
        this.setPolygonColor();
    }

    public Tetrahedron(MyPolygon... polygons) {
        this.color = Color.WHITE;
        this.polygons = polygons;
    }



    private void setPolygonColor() {
        for (MyPolygon poly : this.polygons) {
            poly.setColor(this.color);
        }
    }

    public MyPolygon getPolygonByID(String id) {
        for (MyPolygon polygon : this.polygons) {
            if (polygon.getId().equals(id))
                return polygon;
        }
        System.out.println("No such ID Exists");
        return this.polygons[0];
    }

    public void render(Graphics g) {
        for (MyPolygon poly : this.polygons) {
            poly.render(g);
        }
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        for (MyPolygon p : this.polygons) {
            p.rotate(CW, xDegrees, yDegrees, zDegrees);
        }
        this.sortPolygons();
    }
    private void sortPolygons() {

        ArrayList<MyPolygon> polygonsList = new ArrayList<MyPolygon>();
        for (MyPolygon poly : polygons) {
            polygonsList.add(poly);
        }

        Collections.sort(polygonsList, new Comparator<MyPolygon>() {
            @Override
            public int compare(MyPolygon p1, MyPolygon p2) {
                return p2.getAverageX() - p1.getAverageX() < 0 ? 1 : -1;
            }
        });

        for (int i = 0; i < polygons.length; i++) {
            polygons[i] = polygonsList.get(i);
        }
    }


    public void changeColor(int mouseX, int mouseY, int depth, int distanceAway, Color color) {

        MyPolygon[] temp = new MyPolygon[polygons.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = polygons[i];
        }
        MergeSortAlg.mergeSort(temp, temp.length, mouseX, mouseY, depth); //Sorting on shortest distance from camera
        //System.out.println(temp[0].getId());
        temp[0].setColor(color);

    }

    public void cycle(MyPolygon poly1, MyPolygon poly2, MyPolygon poly3, MyPolygon poly4) {

        Color tempColor = poly1.getColor();

        poly1.setColor(poly2.getColor());
        poly2.setColor(poly3.getColor());
        poly3.setColor(poly4.getColor());
        poly4.setColor(tempColor);
    }

    public void leftFaceBackward() {
        cycle(this.getPolygonByID("W1"), this.getPolygonByID("R1"),
              this.getPolygonByID("Y1"), this.getPolygonByID("O4"));

        cycle(this.getPolygonByID("W7"), this.getPolygonByID("R7"),
              this.getPolygonByID("Y7"), this.getPolygonByID("O8"));

        cycle(this.getPolygonByID("W3"), this.getPolygonByID("R3"),
              this.getPolygonByID("Y3"), this.getPolygonByID("O2"));


        cycle(this.getPolygonByID("G1"), this.getPolygonByID("G2"),
              this.getPolygonByID("G4"), this.getPolygonByID("G3"));

        cycle(this.getPolygonByID("G6"), this.getPolygonByID("G7"),
              this.getPolygonByID("G8"), this.getPolygonByID("G9"));
    }

    public void leftFaceForward() {
        cycle(this.getPolygonByID("O4"), this.getPolygonByID("Y1"),
              this.getPolygonByID("R1"), this.getPolygonByID("W1"));

        cycle(this.getPolygonByID("O8"), this.getPolygonByID("Y7"),
              this.getPolygonByID("R7"), this.getPolygonByID("W7"));

        cycle(this.getPolygonByID("O2"), this.getPolygonByID("Y3"),
              this.getPolygonByID("R3"), this.getPolygonByID("W3"));


        cycle(this.getPolygonByID("G3"), this.getPolygonByID("G4"),
              this.getPolygonByID("G2"), this.getPolygonByID("G1"));

        cycle(this.getPolygonByID("G9"), this.getPolygonByID("G8"),
              this.getPolygonByID("G7"), this.getPolygonByID("G6"));
    }

    public void rightFaceForward() {
        cycle(this.getPolygonByID("O7"), this.getPolygonByID("Y8"),
              this.getPolygonByID("R8"), this.getPolygonByID("W8"));

        cycle(this.getPolygonByID("O3"), this.getPolygonByID("Y4"),
              this.getPolygonByID("R4"), this.getPolygonByID("W4"));

        cycle(this.getPolygonByID("O1"), this.getPolygonByID("Y2"),
              this.getPolygonByID("R2"), this.getPolygonByID("W2"));


        cycle(this.getPolygonByID("B1"), this.getPolygonByID("B2"),
              this.getPolygonByID("B4"), this.getPolygonByID("B3"));

        cycle(this.getPolygonByID("B6"), this.getPolygonByID("B8"),
              this.getPolygonByID("B9"), this.getPolygonByID("B7"));
    }

    public void rightFaceBackward() {
        cycle(this.getPolygonByID("W2"), this.getPolygonByID("R2"),
              this.getPolygonByID("Y2"), this.getPolygonByID("O1"));

        cycle(this.getPolygonByID("W4"), this.getPolygonByID("R4"),
              this.getPolygonByID("Y4"), this.getPolygonByID("O3"));

        cycle(this.getPolygonByID("W8"), this.getPolygonByID("R8"),
              this.getPolygonByID("Y8"), this.getPolygonByID("O7"));

        cycle(this.getPolygonByID("B3"), this.getPolygonByID("B4"),
              this.getPolygonByID("B2"), this.getPolygonByID("B1"));

        cycle(this.getPolygonByID("B7"), this.getPolygonByID("B9"),
              this.getPolygonByID("B8"), this.getPolygonByID("B6"));
    }

    public void topFaceCCW() {
        cycle(this.getPolygonByID("R1"), this.getPolygonByID("B1"),
              this.getPolygonByID("O1"), this.getPolygonByID("G1"));

        cycle(this.getPolygonByID("R2"), this.getPolygonByID("B2"),
              this.getPolygonByID("O2"), this.getPolygonByID("G2"));

        cycle(this.getPolygonByID("R6"), this.getPolygonByID("B6"),
              this.getPolygonByID("O6"), this.getPolygonByID("G6"));


        cycle(this.getPolygonByID("W3"), this.getPolygonByID("W4"),
              this.getPolygonByID("W2"), this.getPolygonByID("W1"));

        cycle(this.getPolygonByID("W7"), this.getPolygonByID("W9"),
              this.getPolygonByID("W8"), this.getPolygonByID("W6"));
    }

    public void topFaceCW() {
        cycle(this.getPolygonByID("G6"), this.getPolygonByID("O6"),
              this.getPolygonByID("B6"), this.getPolygonByID("R6"));

        cycle(this.getPolygonByID("G2"), this.getPolygonByID("O2"),
              this.getPolygonByID("B2"), this.getPolygonByID("R2"));

        cycle(this.getPolygonByID("G1"), this.getPolygonByID("O1"),
              this.getPolygonByID("B1"), this.getPolygonByID("R1"));


        cycle(this.getPolygonByID("W1"), this.getPolygonByID("W2"),
              this.getPolygonByID("W4"), this.getPolygonByID("W3"));

        cycle(this.getPolygonByID("W6"), this.getPolygonByID("W8"),
              this.getPolygonByID("W9"), this.getPolygonByID("W7"));
    }

    public void bottomFaceCCW() {
        cycle(this.getPolygonByID("G9"), this.getPolygonByID("O9"),
              this.getPolygonByID("B9"), this.getPolygonByID("R9"));

        cycle(this.getPolygonByID("G4"), this.getPolygonByID("O4"),
              this.getPolygonByID("B4"), this.getPolygonByID("R4"));

        cycle(this.getPolygonByID("G3"), this.getPolygonByID("O3"),
              this.getPolygonByID("B3"), this.getPolygonByID("R3"));


        cycle(this.getPolygonByID("Y1"), this.getPolygonByID("Y2"),
              this.getPolygonByID("Y4"), this.getPolygonByID("Y3"));

        cycle(this.getPolygonByID("Y6"), this.getPolygonByID("Y8"),
              this.getPolygonByID("Y9"), this.getPolygonByID("Y7"));
    }

    public void bottomFaceCW() {
        cycle(this.getPolygonByID("R3"), this.getPolygonByID("B3"),
              this.getPolygonByID("O3"), this.getPolygonByID("G3"));

        cycle(this.getPolygonByID("R4"), this.getPolygonByID("B4"),
              this.getPolygonByID("O4"), this.getPolygonByID("G4"));

        cycle(this.getPolygonByID("R9"), this.getPolygonByID("B9"),
              this.getPolygonByID("O9"), this.getPolygonByID("G9"));


        cycle(this.getPolygonByID("Y7"), this.getPolygonByID("Y9"),
              this.getPolygonByID("Y8"), this.getPolygonByID("Y6"));

        cycle(this.getPolygonByID("Y3"), this.getPolygonByID("Y4"),
              this.getPolygonByID("Y2"), this.getPolygonByID("Y1"));
    }

    public void frontFaceCW() {
        cycle(this.getPolygonByID("G8"), this.getPolygonByID("Y9"),
              this.getPolygonByID("B7"), this.getPolygonByID("W9"));

        cycle(this.getPolygonByID("G4"), this.getPolygonByID("Y3"),
              this.getPolygonByID("B3"), this.getPolygonByID("W4"));

        cycle(this.getPolygonByID("G2"), this.getPolygonByID("Y4"),
              this.getPolygonByID("B1"), this.getPolygonByID("W3"));


        cycle(this.getPolygonByID("R7"), this.getPolygonByID("R9"),
              this.getPolygonByID("R8"), this.getPolygonByID("R6"));

        cycle(this.getPolygonByID("R3"), this.getPolygonByID("R4"),
              this.getPolygonByID("R2"), this.getPolygonByID("R1"));
    }

    public void frontFaceCCW() {
        cycle(this.getPolygonByID("W3"), this.getPolygonByID("B1"),
              this.getPolygonByID("Y4"), this.getPolygonByID("G2"));

        cycle(this.getPolygonByID("W4"), this.getPolygonByID("B3"),
              this.getPolygonByID("Y3"), this.getPolygonByID("G4"));

        cycle(this.getPolygonByID("W9"), this.getPolygonByID("B7"),
              this.getPolygonByID("Y9"), this.getPolygonByID("G8"));


        cycle(this.getPolygonByID("R1"), this.getPolygonByID("R2"),
              this.getPolygonByID("R4"), this.getPolygonByID("R3"));

        cycle(this.getPolygonByID("R6"), this.getPolygonByID("R8"),
              this.getPolygonByID("R9"), this.getPolygonByID("R7"));
    }

    public void backFaceCCW() {
        cycle(this.getPolygonByID("W1"), this.getPolygonByID("B2"),
              this.getPolygonByID("Y1"), this.getPolygonByID("G1"));

        cycle(this.getPolygonByID("W2"), this.getPolygonByID("B4"),
              this.getPolygonByID("Y2"), this.getPolygonByID("G3"));

        cycle(this.getPolygonByID("W6"), this.getPolygonByID("B8"),
              this.getPolygonByID("Y6"), this.getPolygonByID("G7"));


        cycle(this.getPolygonByID("O7"), this.getPolygonByID("O9"),
              this.getPolygonByID("O8"), this.getPolygonByID("O6"));

        cycle(this.getPolygonByID("O3"), this.getPolygonByID("O4"),
              this.getPolygonByID("O2"), this.getPolygonByID("O1"));
    }

    public void backFaceCW() {
        cycle(this.getPolygonByID("G7"), this.getPolygonByID("Y6"),
              this.getPolygonByID("B8"), this.getPolygonByID("W6"));

        cycle(this.getPolygonByID("G3"), this.getPolygonByID("Y2"),
              this.getPolygonByID("B4"), this.getPolygonByID("W2"));

        cycle(this.getPolygonByID("G1"), this.getPolygonByID("Y1"),
              this.getPolygonByID("B2"), this.getPolygonByID("W1"));


        cycle(this.getPolygonByID("O1"), this.getPolygonByID("O2"),
              this.getPolygonByID("O4"), this.getPolygonByID("O3"));

        cycle(this.getPolygonByID("O6"), this.getPolygonByID("O8"),
              this.getPolygonByID("O9"), this.getPolygonByID("O7"));
    }

}
