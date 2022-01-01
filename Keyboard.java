package renderer.input;

import java.awt.event.*;

public class Keyboard implements KeyListener {

    private int keyID = 0;
    private boolean moveLock = false;

    public int getKeyID() {
        return this.keyID;
    }

    public boolean getMoveLock() {
        return this.moveLock;
    }

    public void setMoveLock(boolean bool) {
        this.moveLock = bool;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyID = e.getKeyCode();
        this.moveLock = true;
    }
}
