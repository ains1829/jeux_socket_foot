package listener;
import java.awt.event.*;
import dessin.*;
import javax.swing.*;
import java.io.*;
import socket.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class ListenerToStart implements MouseListener  {
    FrameToConnect fenetre ;
    ClientSocket cs ;
    public ClientSocket getCs(){
        return cs ;
    }
    public ListenerToStart(FrameToConnect fenetre){   
        super(); 
        this.fenetre = fenetre ;
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==fenetre.getConnected()){
            if(fenetre.getHost().getText().compareToIgnoreCase("")!=0 && fenetre.getPort().getText().compareToIgnoreCase("")!=0 ){
                System.out.println("EN LIGNE") ;
                System.out.println(fenetre.getHost().getText()) ;
                System.out.println(fenetre.getPort().getText()) ;
                String host = fenetre.getHost().getText() ;
                int port = Integer.valueOf(fenetre.getPort().getText());
                new SocketOnline(host,port).start();
            }

        }
        if(e.getSource()==fenetre.getLocal()){
            System.out.println("LOCAl") ;
            new SocketClient().start();
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}