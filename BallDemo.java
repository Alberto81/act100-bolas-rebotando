import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        Random aleatorio= new Random();//random para crear las bolas
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //creo un array tradicional para guardar las bolas
        BouncingBall[] bolas = new BouncingBall[numberOfBalls];
        //comienzo a llenar el array
        for (int index=0; index < numberOfBalls; index++)
        {
            int x = aleatorio.nextInt(250);//me aseguro que sale en la parte izda de la pantalla.
            int y =  aleatorio.nextInt(410)-10;// y esta entre el suelo y el borde superior.
            int diam = aleatorio.nextInt(40)+5;//diametro de las bolas
            //codigo para color aleatorio
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            Color color = new Color(red, green, blue);
            //fin color
            bolas[index] = new BouncingBall(x, y, diam, color, ground, myCanvas);
        }

        //recorro el array dibujando las bolas
        for (int index=0; index < numberOfBalls; index++){
            bolas[index].draw();
        }

     
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);  // small delay
            for (int index=0; index < numberOfBalls; index++){
                bolas[index].move();
                if (bolas[index].getXPosition()>=550){
                    finished = true;
                }
            }

            // stop once ball has travelled a certain distance on x axis

        }
    }
}
