package dessin ;
import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class PanelLabel extends JFrame{
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
    int score1 = 0;
    int score2 = 0;

    public int getScore1(){
        return score1;
    }
    public void setScore(int sco){
        this.score1 = sco ;
    }
    public int getScore2(){
        return score2;
    }
    public void setScore2(int sco){
        this.score2 = sco ;
    }
    public PanelLabel(){
        this.setTitle("SCORE") ;
        JPanel panel = new JPanel() ;
        panel.setLayout(null);
        label = new JLabel("Joueur1 : 0") ;
        label1 = new JLabel("Joueur2 : 0") ;
        label.setBounds(100,50,250,100);
        label.setFont(new Font("Serif" , Font.ITALIC,50));
        label.setForeground(Color.blue);
        label1.setBounds(100,200,250,100);
        label1.setFont(new Font("Serif" , Font.ITALIC,50));
        label1.setForeground(Color.green);
        panel.add(label);
        panel.add(label1);
        panel.setBackground(Color.red) ;
        this.add(panel);
        this.setSize(500,500);
        this.setVisible(true) ;
    }
}