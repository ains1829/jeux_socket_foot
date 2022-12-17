package dessin;
import java.awt.*;
import java.io.FileWriter;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import java.util.Random ;
import java.io.*;
import java.util.TimerTask;
import java.util.Timer;
import person.*;
import fonction.*;
import listener.*;
import socket.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.lang.*;
import java.util.*;
public class Dessin extends JPanel
{
    BufferedImage mypicture ;
    BufferedImage goal ;
    int tour = 1;
    double x_ballon = 470 ;
    double y_ballon = 610;

    double x_calcul = 0 ;
    double y_calcul = 0 ;

    double x_increment ;
    double y_increment;

    Terrain terrain ;
    private static ClientSocket cs ;
    int tire1 = 0 ;
    int tire2 = 0 ;
    int deplacement_goal = 420 ;
    public int getDepalcement_goal(){
        return deplacement_goal ;
    }
    public void setDeplacement( int a ){
        this.deplacement_goal = a ;
    }
    public int getTire1(){
        return this.tire1;
    }
    public void setTire1(int ti){
        this.tire1 = ti ;
    }
    public int getTire2(){
        return this.tire2;
    }
    public void setTire2(int ti){
        this.tire2 = ti ;
    }
    public double getX_increment(){
        return x_increment;
    }
    public double getY_increment(){
        return y_increment;
    }
    public void setX_increment(double x){
        this.x_increment = x;
    }
    public void setY_increment(double y){
        this.y_increment = y;
    }
    boolean move = false;
    int variation = 0 ;
    public boolean getMove(){
        return move;
    }
    public void setMove(boolean move){
        this.move = move;
    }
    public double getX_ballon(){
        return this.x_ballon;
    }
    public double getY_ballon(){
        return this.y_ballon;
    }

    public double getX_calcul(){
        return this.x_calcul;
    }
    public double getY_calcul(){
        return this.y_calcul;
    }
    public void setX_ballon(double x){
        this.x_ballon = x ;
    }
    public void setY_ballon(double y){
        this.y_ballon = y ;
    }

    public void setX_calcul(double x){
        this.x_calcul = x ;
    }
    public void setY_calcul(double y){
        this.y_calcul = y ;
    }
    public int getTour(){
        return this.tour;
    }
    public void setTour(int tour){
        this.tour = tour ;
    }
    public BufferedImage getMypicture() {
        return mypicture;
    }
    public void setMypicture(BufferedImage mypicture) {
        this.mypicture = mypicture;
    }
    int get = 0 ;
    int rand ;
    public int getRand(){
        return rand ;
    }
    public void setRand(int a){
        this.rand = a ;
    }
    public Dessin(Terrain terrain , ClientSocket cs)
    { 
        this.terrain = terrain;
        this.cs = cs ;
        try {
            // cs.seConnecterToServer();
            this.addMouseListener(new Mosy(this));
            this.addMouseMotionListener(new Mosy(this));
            mypicture = ImageIO.read(getClass().getResourceAsStream("/foot.png"));
            goal = ImageIO.read(getClass().getResourceAsStream("/andy.png"));
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    public Dessin(Terrain terrain)
    { 
        this.terrain = terrain;

        try {
            this.addMouseListener(new Mosy(this));
            this.addMouseMotionListener(new Mosy(this));
            mypicture = ImageIO.read(getClass().getResourceAsStream("/foot.png"));
            goal = ImageIO.read(getClass().getResourceAsStream("/andy.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void paint(Graphics g)
    {

        try {
            super.paint(g);
            g.setColor(Color.green);
            g.fillRect(70, 10, 900, 900);
            g.setColor(Color.white);
            g.drawLine(130, 420, 900, 420); 
            g.drawLine(130, 10, 130, 420);
            g.drawLine(900, 10, 900, 420);

            g.setColor(Color.white);
            g.fillOval(490, 640, 20,20);   
            g.drawImage(mypicture,(int) x_ballon,(int) y_ballon,70,50,null);
            g.drawImage(goal,deplacement_goal,30,200,(200-13),null);
            // g.drawImage(new Piece().Get()[0][0],600,500,60,60,null);
               
        } catch (Exception e) {
            // TODO: handle exception
        }

            //but 
            try {
                Thread.sleep(1);
            } catch(Exception e) {}
            // GOAL MOVE 
            if(move==true){
                if(getRand()==0){
                    if(deplacement_goal>150){
                        deplacement_goal = deplacement_goal - 5 ;
                        setDeplacement(deplacement_goal);
                    }
                       
                }else{
                    if(deplacement_goal<650){
                        deplacement_goal = deplacement_goal + 5 ;
                        setDeplacement(deplacement_goal);
                    }
                }
                if(variation==0){
                    try {
                        y_ballon += getY_increment() * 5;
                        setY_ballon(y_ballon);
                        x_ballon += getX_increment() * 5;
                        setX_ballon(x_ballon);
                        // System.out.println("x = " + x_ballon);
                        // System.out.println(" y = " + y_ballon); 
                        Vector v=new Vector();
                        v.add(x_ballon);
                        v.add(y_ballon); //0
                        setTour(getTour()); //1
                        v.add((getTour())); //2
                        v.add(getDepalcement_goal()) ; //3
                        v.add(0); //4
                        cs.sendToServer(v);
                    } catch (Exception e) {
                        e.printStackTrace();
                        // TODO: handle exception
                    }
                }if(((x_ballon >= (deplacement_goal-25) && x_ballon<=(deplacement_goal+150)) && (y_ballon>=180 && y_ballon<=185)) || (y_ballon>615) || (x_ballon<=20) ||(x_ballon>=930) ){
                    variation = 1 ;
                    setTour(getTour());
                    if(this.getTour()%2!=0){
                        System.out.println("joueur1");
                        setMove(false);
                        System.out.println("rater");
                        new Timer().schedule(new TimerTask(){
                            public void run(){
                                setX_ballon(470);
                                setY_ballon(610);
                                setDeplacement(420);
                                try {
                                    Vector v=new Vector();
                                    v.add(x_ballon); //0
                                    v.add(y_ballon); //1
                                    v.add((getTour()+1)); //2
                                    v.add(getDepalcement_goal()) ; //3;
                                    // v.add(terrain.getScore1());
                                    v.add(0) ; //4
                                    cs.sendToServer(v);
                                    } catch (Exception e) {
                                        // TODO: handle exception
                                    }
                            }
                            },1000);
                    }else{
                        System.out.println("joueur2") ;
                        setMove(false);
                        System.out.println("rater");
                        new Timer().schedule(new TimerTask(){
                            public void run(){
                                setX_ballon(470);
                                setY_ballon(610);
                                setDeplacement(420);
                                try {
                                    Vector v=new Vector();
                                    v.add(x_ballon); //0
                                    v.add(y_ballon); // 1
                                    v.add((getTour()+1)); //2
                                    v.add(getDepalcement_goal()) ; //3
                                 //   v.add(getTire2());
                                    // v.add(terrain.getScore2());
                                    v.add(0) ; //4
                                    cs.sendToServer(v);
                                    } catch (Exception e) {
                                        // TODO: handle exception
                                    }
                            }
                            },1000);
                    }
                    variation = 0;
                }if(y_ballon<=10){
                    setTour(getTour());
                        if(this.getTour()%2!=0){
                            System.out.println("joueur1");
                            setMove(false);
                            System.out.println("but");
                            terrain.setScore1(terrain.getScore1()+1) ;
                            new Timer().schedule(new TimerTask(){
                                public void run(){
                                    setX_ballon(470);
                                    setY_ballon(610);
                                    setDeplacement(420);
                                    try {
                                        Vector v=new Vector();
                                        v.add(x_ballon); //0
                                        v.add(y_ballon); //1
                                        v.add((getTour()+1)); //2
                                        v.add(getDepalcement_goal()) ; //3
                                     //   v.add(getTire1());
                                        // v.add(terrain.getScore1());
                                        v.add(1) ; //4
                                        cs.sendToServer(v);
                                        } catch (Exception e) {
                                            // TODO: handle exception
                                        }
                                }
                                },1000);
                        }else{
                        System.out.println("joueur2") ;
                        terrain.setScore2(terrain.getScore2()+1) ;
                        setMove(false);
                        System.out.println("but");
                        new Timer().schedule(new TimerTask(){
                            public void run(){
                                setX_ballon(470);
                                setY_ballon(610);
                                setDeplacement(420);
                                try {
                                Vector v=new Vector();
                                v.add(x_ballon); //0
                                v.add(y_ballon); //1
                                v.add((getTour()+1)); //2
                                v.add(getDepalcement_goal()) ; //3
                                // v.add(getTire2());
                                // v.add(terrain.getScore2());
                                v.add(1) ; //4
                                cs.sendToServer(v);
                                } catch (Exception e) {
                                    // TODO: handle exception
                                }
                            }
                            },1000);
                        }
                    
                }
            }
            repaint();
    }
    
}