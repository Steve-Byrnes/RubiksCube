package renderer;

import renderer.input.ClickType;
import renderer.point.MyPoint;
import renderer.shapes.Cube;
import renderer.shapes.MyPolygon;
import renderer.shapes.Tetrahedron;
import renderer.input.Mouse;
import renderer.input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.Locale;

public class Display extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu paintGame;
    private JTextField textField;
    private JMenuItem colorSelectorPink;
    private JMenuItem colorSelectorRed;
    private JMenuItem colorSelectorCyan;
    private JMenuItem colorSelectorBrown;
    private String moveString = "Selected Side: None";
    private static String title = "Rubik's Cube";
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private static boolean running = false;

    private static Tetrahedron tetra;
    private static double size = 50;

    private Mouse mouse;
    private Keyboard keyboard;
    private int initialX, initialY;
    private int currentKey = 0;
    private int sameKeyCheck = 0;
    private String turningSide = "";
    private static Color paintColor;
    private static boolean canPaint = false;

    public Display() {
        this.frame = new JFrame();
        this.menuBar = new JMenuBar();
        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);

        this.mouse = new Mouse();
        this.addMouseListener(this.mouse);
        this.addMouseMotionListener(this.mouse);
        this.addMouseWheelListener(this.mouse);

        this.keyboard = new Keyboard();
        this.addKeyListener(this.keyboard);

        this.file = new JMenu("File");
        this.paintGame = new JMenu("Paint");
        this.menuBar.add(file);
        this.menuBar.add(paintGame);

        this.colorSelectorPink = new JMenuItem("Pink");
        this.colorSelectorPink.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                canPaint = true;
                setPaintColor(Color.PINK);
            }
        });
        this.colorSelectorBrown = new JMenuItem("Brown");
        this.colorSelectorBrown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canPaint = true;
                setPaintColor(new Color(153,102,0));
            }
        });
        this.colorSelectorCyan = new JMenuItem("Cyan");
        this.colorSelectorCyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canPaint = true;
                setPaintColor(Color.CYAN);
            }
        });
        this.colorSelectorRed = new JMenuItem("Red");
        this.colorSelectorRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canPaint = true;
                setPaintColor(Color.RED);
            }
        });

        this.paintGame.add(colorSelectorPink);
        this.paintGame.add(colorSelectorBrown);
        this.paintGame.add(colorSelectorCyan);
        this.paintGame.add(colorSelectorRed);
        this.textField = new JTextField(moveString);
        this.textField.setEditable(false);
    }

    public static void main(String[] args) {
        Display display = new Display();
        display.frame.setTitle(title);
        display.frame.add(display);
        display.frame.getContentPane().add(BorderLayout.NORTH, display.menuBar);
        display.frame.getContentPane().add(BorderLayout.SOUTH, display.textField);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);
        display.start();
    }

    public synchronized void start() {
       running = true;
       this.thread = new Thread(this, "rubiksCube.Display");
       this.thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60;
        double delta = 0;
        int frames = 0;

        init();

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                this.frame.setTitle(title + " | " + frames + " fps");
                frames = 0;
            }
        }
        stop();
    }

    private void init() {
        this.tetra = Cube.forge(size);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        tetra.render(g);
        g.dispose();
        bs.show();
    }

    public void setPaintColor(Color color) {
        this.paintColor = color;
    }

    private void keyDetectorUp(String s) {
        switch (s) {
            case "f":
                tetra.frontFaceCW();
                break;
            case "ba":
                tetra.backFaceCCW();
                break;
            case "t":
                tetra.topFaceCW();
                break;
            case "bo":
                tetra.bottomFaceCCW();
                break;
            case "l":
                tetra.leftFaceBackward();
                break;
            case "r":
                tetra.rightFaceBackward();
                break;
            default:
                System.out.println("Error: Invalid Move Direction");
        }
    }

    private void keyDetectorDown(String s) {
        switch (s) {
            case "f":
                tetra.frontFaceCCW();
                break;
            case "ba":
                tetra.backFaceCW();
                break;
            case "t":
                tetra.topFaceCCW();
                break;
            case "bo":
                tetra.bottomFaceCW();
                break;
            case "l":
                tetra.leftFaceForward();
                break;
            case "r":
                tetra.rightFaceForward();
                break;
            default:
                System.out.println("Error: Invalid Move Direction");
        }
    }

    private void getTurningSide(int key) {
        switch (key) {
            case 70:
                this.turningSide = "f";
                this.moveString = "Selected Side: Front";
                this.textField.setText(moveString);
                break;
            case 82:
                this.turningSide = "ba";
                this.moveString = "Selected Side: Back";
                this.textField.setText(moveString);
                break;
            case 87:
                this.turningSide = "t";
                this.moveString = "Selected Side: Top";
                this.textField.setText(moveString);
                break;
            case 83:
                this.turningSide = "bo";
                this.moveString = "Selected Side: Bottom";
                this.textField.setText(moveString);
                break;
            case 65:
                this.turningSide = "l";
                this.moveString = "Selected Side: Left";
                this.textField.setText(moveString);
                break;
            case 68:
                this.turningSide = "r";
                this.moveString = "Selected Side: Right";
                this.textField.setText(moveString);
                break;
            default:
                return;
        }
        System.out.println(this.turningSide);
        this.sameKeyCheck = key;
    }

    private void turnSide(int keyID) {
        int key = keyID;

        boolean moveNowLocked = this.keyboard.getMoveLock();

        if (key != this.currentKey || moveNowLocked) {
            if (key == 38) {
                keyDetectorUp(this.turningSide);
                this.keyboard.setMoveLock(false);
            } else if (key == 40) {
                keyDetectorDown(this.turningSide);
                this.keyboard.setMoveLock(false);
            }
            this.currentKey = key;
        }

    }

    private void update() {
        int x = this.mouse.getMouseX();
        int y = this.mouse.getMouseY();
        int key = this.keyboard.getKeyID();

        if (key != this.sameKeyCheck) {
            getTurningSide(key);
        }

        turnSide(key);
        if (this.mouse.getMouseB() == ClickType.LeftClick) {
            int xDif = x - initialX;
            int yDif = y - initialY;
            this.tetra.rotate(true, 0, -yDif/2.5, -xDif/2.5);
        } else if (this.mouse.getMouseB() == ClickType.RightClick) {
            int yDif = y - initialY;
            this.tetra.rotate(true, yDif/2.5, 0,0);
        }

        else if (this.mouse.getMouseB() == ClickType.ScrollClick) {
            if (canPaint) {
                //Center of screen is 250, 250
                int depth = 100;
                tetra.changeColor(x, y, depth, 100, paintColor);
            }
        }

        initialX = x;
        initialY = y;
    }
}
