package renderer.rubiks;

public class Center {

    private String id;

    public Center() {
        this.id = "Not Assigned";
    }

    public Center(String a) {
        this.id = a;
    }

    public String getId() {
        return this.id;
    }

    public void setId(char a) {
        this.id = "" + a;
    }



}
