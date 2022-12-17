package listener;
import dessin.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileWriter;
import java.util.Random ;
public class Listn implements KeyListener{
    Dessin table;
    public Listn(Dessin table){
        this.table = table;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'd' ) {
          
        }
        if(e.getKeyChar() == 's' ) {
       
        }
    }  
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}
    }
    
