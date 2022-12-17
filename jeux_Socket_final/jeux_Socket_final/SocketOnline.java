package socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.lang.*;
import java.util.*;
import javax.sql.rowset.serial.SerialException;
import dessin.*;

public class SocketOnline extends Thread{
    String host ;
    int port ;
        public SocketOnline(String host , int port){
            this.host = host ;
            this.port = port ;
        } 
        public void run(){
                try {
                        ClientSocket cs = new ClientSocket(host,port);
                        cs.seConnecterToServer();
                        Terrain jeu =  new Terrain() ;
                        Dessin d = new Dessin(jeu , cs) ;
                        while(true){
                        Vector message = (Vector) cs.getObjectFromServer();
                        d.setX_ballon(Double.valueOf (message.elementAt(0).toString()));
                        d.setY_ballon(Double.valueOf (message.elementAt(1).toString()));
                        d.setTour(Integer.valueOf(message.elementAt(2).toString())) ;
                        d.setDeplacement(Integer.valueOf(message.elementAt(3).toString()));
                        jeu.setContentPane(d);
                        jeu.setVisible(true);
                        }
                } catch (Exception e) {
                    e.printStackTrace() ;
                        // TODO: handle exception
                }
    }
}