import java.awt.*;
import java.awt.geom.*;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael KÃ¶lling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int downPosition;//margenes del rectangulo
    private final int upPosition;
    private final int leftPosition;
    private final int rightPosition;
    private Canvas canvas;
    

              //asta aqui

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, Canvas drawingCanvas)
    {
       //hacemos la caja
         downPosition=400;//margenes del rectangulo
         upPosition=30;
         leftPosition=30;
         rightPosition=400;
         
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {    int xs = 1;
         int ys = 1;//xs y ys para dirección
        
      
        // remove from canvas at the current position
        erase();
            
  
        yPosition += ys;
        xPosition +=xs;
        
        
        
         // estos ifs para ver si tocan un lado del triangulo y hacerlos rebotar
        if(yPosition >= (downPosition - diameter) || yPosition <= (downPosition - diameter) ){
           ys = -ys;
        
        }

       if(xPosition >= (rightPosition - diameter) || xPosition <= (leftPosition - diameter) ){
           xs = -xs;
        
        }
        
        

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
