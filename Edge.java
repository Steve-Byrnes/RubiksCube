package renderer.rubiks;

public class Edge {

    private String id;

    /*

    a b      b a      b       a
                      a       b

     */

    public Edge() {
        this.id = "Not Assigned";
    }

    public Edge(char a, char b) {
        this.id = "" + a + b;
    }

    public String getId() {
        return this.id;
    }

    public void setId(char a, char b) {
        this.id = "" + a + b;
    }

    public void permuteReflect() {
        char temp1 = this.getId().charAt(0);
        char temp2 = this.getId().charAt(1);
        this.id = "" + temp2 + temp1;
    }

}
