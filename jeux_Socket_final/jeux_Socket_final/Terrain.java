package dessin ;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class Terrain extends JFrame{
    int width = 1000;
    int height = 700; 
    Dessin game;
    PanelLabel text ;
    JButton [] button_point ;
    JButton [] button_point2 ;
    public JButton [] getbutton_point(){
        return this.button_point;
    }
    public void setButton_point(JButton[] button){
        this.button_point = button ;
    }

    public JButton [] getbutton_point2(){
        return this.button_point2;
    }
    public void setButton_point2(JButton[] button){
        this.button_point2 = button ;
    }
    JLabel label ;
    public JLabel getLabel(){
        return label ;
    }
    public void setLabel(JLabel label){
        this.label = label ;
    }

    JLabel label1 ;
    public JLabel getLabel1(){
        return label1 ;
    }
    public void setLabel1(JLabel label){
        this.label1 = label ;
    }
    int score1 = 0 ;
    int score2 = 0 ;

    public int getScore1(){
        return score1;
    }
    public void setScore1(int sco){
        this.score1 = sco ;
    }
    public int getScore2(){
        return score2;
    }
    public void setScore2(int sco){
        this.score2 = sco ;
    }
    public Terrain()throws IOException
    {   
        game = new Dessin(this) ;
        this.setTitle("CLIENT_PENALTIE") ;
        this.add(game); ;
        this.setSize(1100,1000);
        this.setVisible(true);
        //
        // this.setSize(1000,1000);
        // this.setVisible(true);
        // JPanel panel = new JPanel() ;
        // panel.setLayout(null);
        // label = new JLabel("Joueur1 : 0") ;
        // label1 = new JLabel("Joueur2 : 0") ;
        // label.setBounds(1050,100,250,100);
        // label.setFont(new Font("Serif" , Font.ITALIC,50));
        // label.setForeground(Color.blue);
        
        // label1.setBounds(1050,300,250,100);
        // label1.setFont(new Font("Serif" , Font.ITALIC,50));
        // label1.setForeground(Color.green);
        // panel.add(label);
        // panel.add(label1);
        // this.add(panel) ;
    }
}
