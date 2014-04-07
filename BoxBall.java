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
    
   
    public static final int UP_POSITION=30;
    public static final int DOWN_POSITION=300;//margenes del rectangulo
    public static final int LEFT_POSITION=30;
    public static final int RIGHT_POSITION=400;
    
    private Canvas canvas;
    int xs;
    int ys;//xs y ys para dirección, lo pongo aki porqe el movimiento de la bola se simula con multiples ejecuciones de move

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
    
         
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        
          xs = 1;
          ys = 1;//xs y ys para dirección
        
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
    {    
        
      
        // remove from canvas at the current position
        erase();
            
  
        yPosition += ys;
        xPosition +=xs;
        
        
        
         // estos ifs para ver si tocan un lado del triangulo y hacerlos rebotar
         //a tener en cuenta que  las posiciones yPosition y xPosition no indican el centro de la bola.
         //x indica la posición más a la izda de la bola
         //y indica la posicion más superior de la bola
        if(yPosition >= (DOWN_POSITION - diameter) || yPosition <= (UP_POSITION ) ){
           ys = -ys;
        
        }

       if(xPosition >= ( RIGHT_POSITION - diameter) || xPosition <= (LEFT_POSITION) ){
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
