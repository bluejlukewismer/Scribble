import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    public void picOnCanvas()
    {
        //int xPos, int yPos, int width, int height
        myCanvas.setForegroundColor(Color.RED);
        myCanvas.fillRectangle(50, 50, 10, 10);
        myCanvas.setForegroundColor(Color.GREEN);
        myCanvas.fillCircle(50, 50, 50);
        myCanvas.drawString("HULLO", 100, 100);
    }

    public void spiral()
    {
        Pen pen = new Pen();
        for(int i = 0; i<90; i++) {
            pen.move(10*i);
            pen.turn(90);

        }

    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);

    }

    public void drawPolygon(int n, int size)
    {
        Pen pen = new Pen();
        int t = 360 / n;
        for (int i=0; i<n; i++) {
            pen.move(size);
            pen.turn(t);

        }
    }

    public void drawPentagon()
    {
        Pen pen = new Pen(150, 150, myCanvas);
        pen.setColor(Color.MAGENTA);
        pentagon(pen);

    }

    public void drawTriangle()
    {
        Pen pen = new Pen(150, 150, myCanvas);
        pen.setColor(Color.GREEN);

        triangle(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(1);
        }
    }

    public void pentagon(Pen pen)
    {
        for (int i=0; i<5; i++) {
            pen.move(50);
            pen.turn(72);
        }

    }

    public void triangle(Pen pen)
    {
        for (int i=0; i<3; i++) {
            pen.move(50);
            pen.turn(120);
        }

    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
