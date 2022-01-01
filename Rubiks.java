package renderer.rubiks;

public class Rubiks {
    private Center[] centers = new Center[6];
    private Edge[] edges = new Edge[12];
    private Corner[] corners = new Corner[8];
    Edge tempEdge = new Edge();
    Corner tempCorner = new Corner();

    public Rubiks() {
        for (int i = 0; i < this.centers.length; i++ ) {
            this.centers[i] = new Center();
        }
        centers[0].setId('W');
        centers[1].setId('O');
        centers[2].setId('G');
        centers[3].setId('Y');
        centers[4].setId('B');
        centers[5].setId('R');

        for (int i = 0; i < this.edges.length; i++) {
            this.edges[i] = new Edge();
        }
        edges[0].setId('W','R');
        edges[1].setId('W','G');
        edges[2].setId('W','B');
        edges[3].setId('W','O');
        edges[4].setId('O','G');
        edges[5].setId('O','B');
        edges[6].setId('O','Y');
        edges[7].setId('Y','G');
        edges[8].setId('Y','B');
        edges[9].setId('R','G');
        edges[10].setId('R','Y');
        edges[11].setId('R','B');

        for (int i = 0; i < this.corners.length; i++) {
            this.corners[i] = new Corner();
        }
        corners[0].setId('G','W','R');
        corners[1].setId('R','W','B');
        corners[2].setId('O','W','G');
        corners[3].setId('B','W','O');
        corners[4].setId('G','Y','O');
        corners[5].setId('O','Y','B');
        corners[6].setId('R','Y','G');
        corners[7].setId('B','Y','R');
    }

    public Center[] getCenters() {
        return this.centers;
    }
    public Corner[] getCorners() {
        return this.corners;
    }
    public Edge[] getEdges() {
        return this.edges;
    }


    //LeftFace Moves
    public void leftFaceBackward() {
        corners[0].permuteBackward();
        corners[2].permuteForward();
        corners[4].permuteBackward();
        corners[6].permuteForward();

        tempCorner = corners[0];
        corners[0] = corners[6];
        corners[6] = corners[4];
        corners[4] = corners[2];
        corners[2] = tempCorner;

        tempEdge = edges[1];
        edges[1] = edges[9];
        edges[9] = edges[7];
        edges[7] = edges[4];
        edges[4] = tempEdge;
    }

    public void leftFaceForward() {
        corners[0].permuteBackward();
        corners[2].permuteForward();
        corners[4].permuteBackward();
        corners[6].permuteForward();

        tempCorner = corners[0];
        corners[0] = corners[2];
        corners[2] = corners[4];
        corners[4] = corners[6];
        corners[6] = tempCorner;

        tempEdge = edges[1];
        edges[1] = edges[4];
        edges[4] = edges[7];
        edges[7] = edges[9];
        edges[9] = tempEdge;
    }

    //rightFace Moves
    public void rightFaceBackward() {
        corners[1].permuteForward();
        corners[3].permuteBackward();
        corners[5].permuteForward();
        corners[7].permuteBackward();

        tempCorner = corners[1];
        corners[1] = corners[7];
        corners[7] = corners[5];
        corners[5] = corners[3];
        corners[3] = tempCorner;

        tempEdge = edges[2];
        edges[2] = edges[11];
        edges[11] = edges[8];
        edges[8] = edges[5];
        edges[5] = tempEdge;
    }

    public void rightFaceForward() {
        corners[1].permuteForward();
        corners[3].permuteBackward();
        corners[5].permuteForward();
        corners[7].permuteBackward();

        tempCorner = corners[1];
        corners[1] = corners[3];
        corners[3] = corners[5];
        corners[5] = corners[7];
        corners[7] = tempCorner;

        tempEdge = edges[2];
        edges[2] = edges[5];
        edges[5] = edges[8];
        edges[8] = edges[11];
        edges[11] = tempEdge;
    }

    //topFace Moves
    public void topFaceCCW() {
        tempCorner = corners[0];
        corners[0] = corners[1];
        corners[1] = corners[3];
        corners[3] = corners[2];
        corners[2] = tempCorner;

        tempEdge = edges[1];
        edges[1] = edges[0];
        edges[0] = edges[2];
        edges[2] = edges[3];
        edges[3] = tempEdge;
    }

    public void topFaceCW() {
        tempCorner = corners[0];
        corners[0] = corners[2];
        corners[2] = corners[3];
        corners[3] = corners[1];
        corners[1] = tempCorner;

        tempEdge = edges[1];
        edges[1] = edges[3];
        edges[3] = edges[2];
        edges[2] = edges[0];
        edges[0] = tempEdge;
    }

    //bottomFace Moves
    public void bottomFaceCCW() {
        tempCorner = corners[6];
        corners[6] = corners[7];
        corners[7] = corners[5];
        corners[5] = corners[4];
        corners[4] = tempCorner;

        edges[7].permuteReflect();
        edges[10].permuteReflect();
        edges[8].permuteReflect();
        edges[6].permuteReflect();

        tempEdge = edges[7];
        edges[7] = edges[10];
        edges[10] = edges[8];
        edges[8] = edges[6];
        edges[6] = tempEdge;
    }

    public void bottomFaceCW() {
        tempCorner = corners[6];
        corners[6] = corners[4];
        corners[4] = corners[5];
        corners[5] = corners[7];
        corners[7] = tempCorner;

        edges[7].permuteReflect();
        edges[10].permuteReflect();
        edges[8].permuteReflect();
        edges[6].permuteReflect();

        tempEdge = edges[7];
        edges[7] = edges[6];
        edges[6] = edges[8];
        edges[8] = edges[10];
        edges[10] = tempEdge;
    }

    //frontFace Moves
    public void frontFaceCW() {
        corners[0].permuteForward();
        corners[1].permuteBackward();
        corners[7].permuteForward();
        corners[6].permuteBackward();

        tempCorner = corners[0];
        corners[0] = corners[6];
        corners[6] = corners[7];
        corners[7] = corners[1];
        corners[1] = tempCorner;

        edges[0].permuteReflect();
        edges[9].permuteReflect();

        tempEdge = edges[0];
        edges[0] = edges[9];
        edges[9] = edges[10];
        edges[10] = edges[11];
        edges[11] = tempEdge;
    }

    public void frontFaceCCW() {
        corners[0].permuteForward();
        corners[1].permuteBackward();
        corners[7].permuteForward();
        corners[6].permuteBackward();

        tempCorner = corners[0];
        corners[0] = corners[1];
        corners[1] = corners[7];
        corners[7] = corners[6];
        corners[6] = tempCorner;

        edges[0].permuteReflect();
        edges[11].permuteReflect();

        tempEdge = edges[0];
        edges[0] = edges[11];
        edges[11] = edges[10];
        edges[10] = edges[9];
        edges[9] = tempEdge;
    }

    //backFace Moves
    public void backFaceCW() {
        corners[2].permuteBackward();
        corners[3].permuteForward();
        corners[5].permuteBackward();
        corners[4].permuteForward();

        tempCorner = corners[2];
        corners[2] = corners[4];
        corners[4] = corners[5];
        corners[5] = corners[3];
        corners[3] = tempCorner;

        edges[3].permuteReflect();
        edges[4].permuteReflect();

        tempEdge = edges[3];
        edges[3] = edges[4];
        edges[4] = edges[6];
        edges[6] = edges[5];
        edges[5] = tempEdge;
    }

    public void backFaceCCW() {
        corners[2].permuteBackward();
        corners[3].permuteForward();
        corners[5].permuteBackward();
        corners[4].permuteForward();

        tempCorner = corners[2];
        corners[2] = corners[3];
        corners[3] = corners[5];
        corners[5] = corners[4];
        corners[4] = tempCorner;

        edges[3].permuteReflect();
        edges[5].permuteReflect();

        tempEdge = edges[3];
        edges[3] = edges[5];
        edges[5] = edges[6];
        edges[6] = edges[4];
        edges[4] = tempEdge;
    }

    public void printWhiteFace() {
        System.out.print(corners[2].getId().charAt(1) + " ");
        System.out.print(edges[3].getId().charAt(0) + " ");
        System.out.print(corners[3].getId().charAt(1) + " ");
        System.out.println();
        System.out.print(edges[1].getId().charAt(0) + " ");
        System.out.print(centers[0].getId() + " ");
        System.out.print(edges[2].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(corners[0].getId().charAt(1) + " ");
        System.out.print(edges[0].getId().charAt(0) + " ");
        System.out.print(corners[1].getId().charAt(1) + " ");
    }

    public void printRedFace() {
        System.out.print(corners[0].getId().charAt(2) + " ");
        System.out.print(edges[0].getId().charAt(1) + " ");
        System.out.print(corners[1].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(edges[9].getId().charAt(0) + " ");
        System.out.print(centers[5].getId() + " ");
        System.out.print(edges[11].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(corners[6].getId().charAt(0) + " ");
        System.out.print(edges[10].getId().charAt(0) + " ");
        System.out.print(corners[7].getId().charAt(2) + " ");
    }

    public void printBlueFace() {
        System.out.print(corners[1].getId().charAt(2) + " ");
        System.out.print(edges[2].getId().charAt(1) + " ");
        System.out.print(corners[3].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(edges[11].getId().charAt(1) + " ");
        System.out.print(centers[4].getId() + " ");
        System.out.print(edges[5].getId().charAt(1) + " ");
        System.out.println();
        System.out.print(corners[7].getId().charAt(0) + " ");
        System.out.print(edges[8].getId().charAt(1) + " ");
        System.out.print(corners[5].getId().charAt(2) + " ");
    }

    public void printGreenFace() {
        System.out.print(corners[2].getId().charAt(2) + " ");
        System.out.print(edges[1].getId().charAt(1) + " ");
        System.out.print(corners[0].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(edges[4].getId().charAt(1) + " ");
        System.out.print(centers[2].getId() + " ");
        System.out.print(edges[9].getId().charAt(1) + " ");
        System.out.println();
        System.out.print(corners[4].getId().charAt(0) + " ");
        System.out.print(edges[7].getId().charAt(1) + " ");
        System.out.print(corners[6].getId().charAt(2) + " ");
    }

    public void printOrangeFace() {
        System.out.print(corners[3].getId().charAt(2) + " ");
        System.out.print(edges[3].getId().charAt(1) + " ");
        System.out.print(corners[2].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(edges[5].getId().charAt(0) + " ");
        System.out.print(centers[1].getId() + " ");
        System.out.print(edges[4].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(corners[5].getId().charAt(0) + " ");
        System.out.print(edges[6].getId().charAt(0) + " ");
        System.out.print(corners[4].getId().charAt(2) + " ");
    }

    public void printYellowFace() {
        System.out.print(corners[6].getId().charAt(1) + " ");
        System.out.print(edges[10].getId().charAt(1) + " ");
        System.out.print(corners[7].getId().charAt(1) + " ");
        System.out.println();
        System.out.print(edges[7].getId().charAt(0) + " ");
        System.out.print(centers[3].getId() + " ");
        System.out.print(edges[8].getId().charAt(0) + " ");
        System.out.println();
        System.out.print(corners[4].getId().charAt(1) + " ");
        System.out.print(edges[6].getId().charAt(1) + " ");
        System.out.print(corners[5].getId().charAt(1) + " ");
    }

}
