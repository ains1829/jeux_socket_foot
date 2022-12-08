package dessin ;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class TerrainServeur extends JFrame{
    int width = 1000;
    int height = 700; 
    DessinServeur game;
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
    int score1 ;
    int score2;

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
    public TerrainServeur()throws IOException
    {   
        game = new DessinServeur(this) ;
        this.setTitle("PENALTIE") ;
        this.add(game);
        this.setSize(1000,1000);
        this.setVisible(true);
        JPanel panel = new JPanel() ;
        panel.setLayout(null);
        label = new JLabel("Joueur1 : 0") ;
        label1 = new JLabel("Joueur2 : 0") ;
        label.setBounds(1050,100,250,100);
        label.setFont(new Font("Serif" , Font.ITALIC,50));
        label.setForeground(Color.blue);
        button_point = new JButton[6];
        button_point[1] = new JButton();
        button_point[2] = new JButton();
        button_point[3] = new JButton();
        button_point[4] = new JButton();
        button_point[5] = new JButton();

        button_point[1].setBounds(1050,210,40,40);
        button_point[2].setBounds(1090,210,40,40);
        button_point[3].setBounds(1130,210,40,40);
        button_point[4].setBounds(1170,210,40,40);
        button_point[5].setBounds(1210,210,40,40);

        for(int i = 1  ;i<button_point.length;i++){
            button_point[i].setBackground(Color.white);
            panel.add(button_point[i]);
        }

        button_point2 = new JButton[6];
        button_point2[1] = new JButton();
        button_point2[2] = new JButton();
        button_point2[3] = new JButton();
        button_point2[4] = new JButton();
        button_point2[5] = new JButton();

        button_point2[1].setBounds(1050,410,40,40);
        button_point2[2].setBounds(1090,410,40,40);
        button_point2[3].setBounds(1130,410,40,40);
        button_point2[4].setBounds(1170,410,40,40);
        button_point2[5].setBounds(1210,410,40,40);

        for(int i = 1  ;i<button_point2.length;i++){
            button_point2[i].setBackground(Color.white);
            panel.add(button_point2[i]);
        }
        label1.setBounds(1050,300,250,100);
        label1.setFont(new Font("Serif" , Font.ITALIC,50));
        label1.setForeground(Color.green);
        panel.add(label);
        panel.add(label1);
        this.add(panel) ;
        this.setSize(1500,1000);
        this.setVisible(true);
    }
}
