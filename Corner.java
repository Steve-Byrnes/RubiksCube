package renderer.rubiks;

import java.awt.*;

public class Corner {

    public String id;
    public String faceAssignment;

    public Corner() {
        this.id = "Not Assigned";
    }

    public Corner(char a, char b, char c) {
        this.id = "" + a + b + c;
    }

    /*

    a
    b c

    b a     c b
    c         a

    a         c
    b c     a b

     */

    public String getId() {
        return this.id;
    }

    public void setId(char a, char b, char c) {
        this.id = "" + a + b + c;
    }

    public void reflect() {
       char temp1 = this.id.charAt(0);
       char temp2 = this.id.charAt(1);
       char temp3 = this.id.charAt(2);
       this.id = "" + temp3 + temp2 + temp1;
    }

    public void permuteForward() {
        char temp1 = this.id.charAt(0);
        char temp2 = this.id.charAt(1);
        char temp3 = this.id.charAt(2);
        this.id = "" + temp3 + temp1 + temp2;
    }

    public void permuteBackward() {
        char temp1 = this.id.charAt(0);
        char temp2 = this.id.charAt(1);
        char temp3 = this.id.charAt(2);
        this.id = "" + temp2 + temp3 + temp1;
    }

}
