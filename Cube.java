package renderer.shapes;

import renderer.point.MyPoint;
import java.awt.*;

public class Cube {

    public static Color darkWhite = new Color(220, 220, 220);
    public static Color darkRed = new Color(183, 42, 42);
    public static Color darkBlue = new Color(43, 0, 255);
    public static Color darkOrange = new Color(255, 128, 0);
    public static Color darkerOrange = new Color(205, 143, 0);
    public static Color darkGreen = new Color(76, 153, 0);
    public static Color darkYellow = new Color(229, 206, 0);

    public static MyPoint a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16,
                          b1, b2, b3, b4, b5, b8, b9, b12, b13, b14, b15, b16, //Missing points b/c cube is hollow
                          c1, c2, c3, c4, c5, c8, c9, c12, c13, c14, c15, c16,
                          d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16;

    public static MyPolygon[] faceOne = new MyPolygon[9]; //White
    public static MyPolygon[] faceTwo = new MyPolygon[9]; //Red
    public static MyPolygon[] faceThree = new MyPolygon[9]; //Blue
    public static MyPolygon[] faceFour = new MyPolygon[9]; //Orange
    public static MyPolygon[] faceFive = new MyPolygon[9]; //Green
    public static MyPolygon[] faceSix = new MyPolygon[9]; //Yellow

    public static Tetrahedron forge(double size) {

        //X is depth, Y is LR (neg is left), Z is UD (neg is up)
        a1 = new MyPoint(1.5 * size, -1.5 * size, 1.5 * size);
        a2 = new MyPoint(1.5 * size, -size/2, 1.5 * size);
        a3 = new MyPoint(1.5 * size, size/2, 1.5 * size);
        a4 = new MyPoint(1.5 * size, 1.5 * size, 1.5 * size);
        a5 = new MyPoint(1.5 * size, -1.5 * size, size/2);
        a6 = new MyPoint(1.5 * size, -size/2, size/2);
        a7 = new MyPoint(1.5 * size, size/2, size/2);
        a8 = new MyPoint(1.5 * size, 1.5 * size, size/2);
        a9 = new MyPoint(1.5 * size, -1.5 * size, -size/2);
        a10 = new MyPoint(1.5 * size, -size/2, -size/2);
        a11 = new MyPoint(1.5 * size, size/2, -size/2);
        a12 = new MyPoint(1.5 * size, 1.5 * size, -size/2);
        a13 = new MyPoint(1.5 * size, -1.5 * size, -1.5 * size);
        a14 = new MyPoint(1.5 * size, -size/2, -1.5 * size);
        a15 = new MyPoint(1.5 * size, size/2, -1.5 * size);
        a16 = new MyPoint(1.5 * size, 1.5 * size, -1.5 * size);

        b1 = new MyPoint(size/2, -1.5 * size, 1.5 * size);
        b2 = new MyPoint(size/2, -size/2, 1.5 * size);
        b3 = new MyPoint(size/2, size/2, 1.5 * size);
        b4 = new MyPoint(size/2, 1.5 * size, 1.5 * size);
        b5 = new MyPoint(size/2, -1.5 * size, size/2);
        b8 = new MyPoint(size/2, 1.5 * size, size/2);
        b9 = new MyPoint(size/2, -1.5 * size, -size/2);
        b12 = new MyPoint(size/2, 1.5 * size, -size/2);
        b13 = new MyPoint(size/2, -1.5 * size, -1.5 * size);
        b14 = new MyPoint(size/2, -size/2, -1.5 * size);
        b15 = new MyPoint(size/2, size/2, -1.5 * size);
        b16 = new MyPoint(size/2, 1.5 * size, -1.5 * size);

        c1 = new MyPoint(-size/2, -1.5 * size, 1.5 * size);
        c2 = new MyPoint(-size/2, -size/2, 1.5 * size);
        c3 = new MyPoint(-size/2, size/2, 1.5 * size);
        c4 = new MyPoint(-size/2, 1.5 * size, 1.5 * size);
        c5 = new MyPoint(-size/2, -1.5 * size, size/2);
        c8 = new MyPoint(-size/2, 1.5 * size, size/2);
        c9 = new MyPoint(-size/2, -1.5 * size, -size/2);
        c12 = new MyPoint(-size/2, 1.5 * size, -size/2);
        c13 = new MyPoint(-size/2, -1.5 * size, -1.5 * size);
        c14 = new MyPoint(-size/2, -size/2, -1.5 * size);
        c15 = new MyPoint(-size/2, size/2, -1.5 * size);
        c16 = new MyPoint(-size/2, 1.5 * size, -1.5 * size);

        d1 = new MyPoint(-1.5 * size, -1.5 * size, 1.5 * size);
        d2 = new MyPoint(-1.5 * size, -size/2, 1.5 * size);
        d3 = new MyPoint(-1.5 * size, size/2, 1.5 * size);
        d4 = new MyPoint(-1.5 * size, 1.5 * size, 1.5 * size);
        d5 = new MyPoint(-1.5 * size, -1.5 * size, size/2);
        d6 = new MyPoint(-1.5 * size, -size/2, size/2);
        d7 = new MyPoint(-1.5 * size, size/2, size/2);
        d8 = new MyPoint(-1.5 * size, 1.5 * size, size/2);
        d9 = new MyPoint(-1.5 * size, -1.5 * size, -size/2);
        d10 = new MyPoint(-1.5 * size, -size/2, -size/2);
        d11 = new MyPoint(-1.5 * size, size/2, -size/2);
        d12 = new MyPoint(-1.5 * size, 1.5 * size, -size/2);
        d13 = new MyPoint(-1.5 * size, -1.5 * size, -1.5 * size);
        d14 = new MyPoint(-1.5 * size, -size/2, -1.5 * size);
        d15 = new MyPoint(-1.5 * size, size/2, -1.5 * size);
        d16 = new MyPoint(-1.5 * size, 1.5 * size, -1.5 * size);

        //White
        faceOne[0] = new MyPolygon("W1", Color.WHITE, a1, a2, a6, a5);
        faceOne[1] = new MyPolygon("W2", Color.WHITE, a3, a7, a8, a4);
        faceOne[2] = new MyPolygon("W3", Color.WHITE, a9, a10, a14, a13);
        faceOne[3] = new MyPolygon("W4", Color.WHITE, a11, a12, a16, a15);
        faceOne[4] = new MyPolygon("W5", Color.WHITE, a6, a7, a11, a10);
        faceOne[5] = new MyPolygon("W6", darkWhite, a2, a3, a7, a6);
        faceOne[6] = new MyPolygon("W7", darkWhite, a5, a6, a10, a9);
        faceOne[7] = new MyPolygon("W8", darkWhite, a7, a8, a12, a11);
        faceOne[8] = new MyPolygon("W9", darkWhite, a10, a11, a15, a14);

        //Red
        faceTwo[0] = new MyPolygon("R1", Color.RED, a13, a14, b14, b13);
        faceTwo[1] = new MyPolygon("R2", Color.RED, a15, a16, b16, b15);
        faceTwo[2] = new MyPolygon("R3", Color.RED, c13, c14, d14, d13);
        faceTwo[3] = new MyPolygon("R4", Color.RED, c15, c16, d16, d15);
        faceTwo[4] = new MyPolygon("R5", Color.RED, b14, b15, c15, c14);
        faceTwo[5] = new MyPolygon("R6", darkRed, a14, a15, b15, b14);
        faceTwo[6] = new MyPolygon("R7", darkRed, b13, b14, c14, c13);
        faceTwo[7] = new MyPolygon("R8", darkRed, b15, b16, c16, c15);
        faceTwo[8] = new MyPolygon("R9", darkRed, c14, c15, d15, d14);

        //Blue
        faceThree[0] = new MyPolygon("B1", Color.BLUE, a12, b12, b16, a16);
        faceThree[1] = new MyPolygon("B2", Color.BLUE, a4, b4, b8, a8);
        faceThree[2] = new MyPolygon("B3", Color.BLUE, c12, d12, d16, c16);
        faceThree[3] = new MyPolygon("B4", Color.BLUE, c4, d4, d8, c8);
        faceThree[4] = new MyPolygon("B5", Color.BLUE, b8, c8, c12, b12);
        faceThree[5] = new MyPolygon("B6", darkBlue, a12, a8, b8, b12);
        faceThree[6] = new MyPolygon("B7", darkBlue, b16, b12, c12, c16);
        faceThree[7] = new MyPolygon("B8", darkBlue, b8, b4, c4, c8);
        faceThree[8] = new MyPolygon("B9", darkBlue, c12, c8, d8, d12);

        //Orange
        faceFour[0] = new MyPolygon("O1", darkOrange, a4, a3, b3, b4);
        faceFour[1] = new MyPolygon("O2", darkOrange, a2, a1, b1, b2);
        faceFour[2] = new MyPolygon("O3", darkOrange, c4, c3, d3, d4);
        faceFour[3] = new MyPolygon("O4", darkOrange, c2, c1, d1, d2);
        faceFour[4] = new MyPolygon("O5", darkOrange, b3, b2, c2, c3);
        faceFour[5] = new MyPolygon("O6", darkerOrange, a3, a2, b2, b3);
        faceFour[6] = new MyPolygon("O7", darkerOrange, b4, b3, c3, c4);
        faceFour[7] = new MyPolygon("O8", darkerOrange, b2, b1, c1, c2);
        faceFour[8] = new MyPolygon("O9", darkerOrange, c3, c2, d2, d3);

        //Green
        faceFive[0] = new MyPolygon("G1", Color.GREEN, a1, a5, b5, b1);
        faceFive[1] = new MyPolygon("G2", Color.GREEN, a9, a13, b13, b9);
        faceFive[2] = new MyPolygon("G3", Color.GREEN, c1, c5, d5, d1);
        faceFive[3] = new MyPolygon("G4", Color.GREEN, c9, c13, d13, d9);
        faceFive[4] = new MyPolygon("G5", Color.GREEN, b5, b9, c9, c5);
        faceFive[5] = new MyPolygon("G6", darkGreen, a5, a9, b9, b5);
        faceFive[6] = new MyPolygon("G7", darkGreen, b1, b5, c5, c1);
        faceFive[7] = new MyPolygon("G8", darkGreen, b9, b13, c13, c9);
        faceFive[8] = new MyPolygon("G9", darkGreen, c5, c9, d9, d5);

        //Yellow
        faceSix[0] = new MyPolygon("Y1", Color.YELLOW, d1, d2, d6, d5);
        faceSix[1] = new MyPolygon("Y2", Color.YELLOW, d3, d7, d8, d4);
        faceSix[2] = new MyPolygon("Y3", Color.YELLOW, d9, d10, d14, d13);
        faceSix[3] = new MyPolygon("Y4", Color.YELLOW, d11, d12, d16, d15);
        faceSix[4] = new MyPolygon("Y5", Color.YELLOW, d6, d7, d11, d10);
        faceSix[5] = new MyPolygon("Y6", darkYellow, d2, d3, d7, d6);
        faceSix[6] = new MyPolygon("Y7", darkYellow, d5, d6, d10, d9);
        faceSix[7] = new MyPolygon("Y8", darkYellow, d7, d8, d12, d11);
        faceSix[8] = new MyPolygon("Y9", darkYellow, d10, d11, d15, d14);

        return new Tetrahedron(
            //0 - 8
                /*
                -------------
                | 1 | 6 | 2 |
                | 7 | 5 | 8 |
                | 3 | 9 | 4 |
                -------------
                 */
        faceOne[0], faceOne[1], faceOne[2], faceOne[3], faceOne[4],
        faceOne[5], faceOne[6], faceOne[7], faceOne[8],

            //9 - 17
        faceTwo[0], faceTwo[1], faceTwo[2], faceTwo[3], faceTwo[4],
        faceTwo[5], faceTwo[6], faceTwo[7], faceTwo[8],

            //18 - 26
        faceThree[0], faceThree[1], faceThree[2], faceThree[3], faceThree[4],
        faceThree[5], faceThree[6], faceThree[7], faceThree[8],

            //27 - 35
        faceFour[0], faceFour[1], faceFour[2], faceFour[3], faceFour[4],
        faceFour[5], faceFour[6], faceFour[7], faceFour[8],

            //36 - 44
        faceFive[0], faceFive[1], faceFive[2], faceFive[3], faceFive[4],
        faceFive[5], faceFive[6], faceFive[7], faceFive[8],

            //45 - 53
        faceSix[0], faceSix[1], faceSix[2], faceSix[3], faceSix[4],
        faceSix[5], faceSix[6], faceSix[7], faceSix[8]);
    }

}
