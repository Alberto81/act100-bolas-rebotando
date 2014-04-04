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
     * boxbounce a partir de bounce
     */
    public void boxBounce(int numberOfBalls)
    {
      Random aleatorio= new Random();
      myCanvas.setVisible(true);
      myCanvas.drawRectangle();//como el rectangulo es fijo, hice trampas y lo cree sin parametros
      BoxBall[] bolas = new BoxBall[numberOfBalls];
      
      
       for (int index=0; index < numberOfBalls; index++)
        {
            int x = aleatorio.nextInt(395)-35;//hago que salgan dentro del rectangulo
            int y = aleatorio.nextInt(395)-35;
            
            int diam = aleatorio.nextInt(40)+5;//diametro de las bolas
            //codigo para color aleatorio
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            //el if evita bolas muy claras, que no se ven por el f0nd0.
            if (red > 250 && green > 250 && blue > 250){
                red = 0;
                green = 0;
                blue = 0;
            }
            Color color = new Color(red, green, blue);
            //fin color
            bolas[index] = new BoxBall(x, y, diam, color, myCanvas);
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
                if (bolas[index].getXPosition()>=430){
                    finished = true;
                }
            }
      
      
    }
    
}
    
    /**
     * Simulate n bouncing balls
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
            //del borde superior a la mitad de la distancia al suelo, para que boten.
            int y =  aleatorio.nextInt(200)-10;
            int diam = aleatorio.nextInt(40)+5;//diametro de las bolas
            //codigo para color aleatorio
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            //el if evita bolas muy claras, que no se ven por el f0nd0.
            if (red > 250 && green > 250 && blue > 250){
                red = 0;
                green = 0;
                blue = 0;
            }
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
