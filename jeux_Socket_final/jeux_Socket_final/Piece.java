package person;

import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import fonction.*;
public class Piece  {
    int count=0;
    BufferedImage imagePersonnage;
    BufferedImage[][] imagePersonnageSingel;
    public Piece()throws IOException{
     Process();
    }
    public void Process()throws IOException{
        imagePersonnage = new Fonction().load("Personnage.png");
        imagePersonnageSingel=new Fonction().process(imagePersonnage, 2, 7,24,36) ;
    }
    public BufferedImage[][] Get(){
        return imagePersonnageSingel;
    }
    public int GetCount(){
        return count;
    }
    public void SetCount(int number){count=number;}
}
