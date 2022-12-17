package listener;
import dessin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import fonction.*;
import java.util.Timer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class MosyServeur implements MouseListener, MouseMotionListener{
   int tour = 0;
   DessinServeur foot;
   int tentative1 = 0 ;
   int tentative2 = 0 ;
   int but1 = 0 ;
   int but2 = 0 ;
   public MosyServeur(DessinServeur foot)
   {
      this.foot = foot ;
   }
      public void mouseDragged(MouseEvent e){}
      public void mouseClicked(MouseEvent e){ 
         Random a = new Random() ;
         int b = a.nextInt(2) ;
         foot.setRand(b);
         System.out.println(b) ;
            if(foot.getTour()%2!=0){
               // if(foot.getTire1()!=5){
                  // foot.setTire1(foot.getTire1()+1);
                  System.out.println("Joueur1") ;
                  foot.setX_calcul(e.getX());
                  foot.setY_calcul(e.getY());
                  new FonctionServeur().vecteurDirection(foot);
                  foot.setMove(true);
   
               // }
            }
            else{
               // if(foot.getTire2()!=5){
                  // foot.setTire2(foot.getTire2()+1);
                  System.out.println("Joueur2") ;
                  foot.setX_calcul(e.getX());
                  foot.setY_calcul(e.getY());
                  new FonctionServeur().vecteurDirection(foot);
                  foot.setMove(true);
               // }
            }
      }
      public void mouseMoved(MouseEvent e){}
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mousePressed(MouseEvent e) {
      }
      public void mouseReleased(MouseEvent e) {}
}