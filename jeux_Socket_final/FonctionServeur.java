package fonction;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import dessin.*;
import java.math.*;
public class FonctionServeur{
    public FonctionServeur(){}
    public BufferedImage load(String path) throws IOException {
        BufferedImage img = ImageIO.read(new File(path));           
        return img;
    } 
    public BufferedImage[][] process(BufferedImage myPicture,int Ligne,int colone,int width,int height){
        BufferedImage[][] image = new BufferedImage[Ligne][colone];
        for (int i = 0; i < Ligne; i++) {
            for (int k = 0; k < colone; k++) {
                image[i][k] = myPicture.getSubimage(k*width,i*height, width, height);
            }
        }
    return image;
    } 
    public void vecteurDirection(DessinServeur de){
        double d_x = delta_x(de.getX_ballon(), de.getX_calcul());
        double d_y = delta_y(de.getY_ballon(), de.getY_calcul());
        double alpha = Math.atan2(d_y, d_x);
        de.setX_increment(Math.cos(alpha));
        de.setY_increment(Math.sin(alpha));
    }
    public double delta_x(double x1, double x2){
        return (x2-x1);
    }
    public double delta_y(double y1 , double y2){
        return (y2-y1);
    }
}