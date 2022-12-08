package socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
import dessin.*;
public class SocketServeur {
    private static ServerSocket server;
    private static int port = 9898;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        SocketServer ss=new SocketServer();
        TerrainServeur jeu = new TerrainServeur();
        ss.waitAndAcceptAndTakeSocketClient();
        DessinServeur d = new DessinServeur(jeu,ss);
        while(true){
        Vector message = (Vector) ss.getObjectFromClient();
        // d.setMove(Boolean.valueOf(message.elementAt(0).toString()));
        // System.out.println("values = " +  d.getMove());
        d.setX_ballon(Double.valueOf (message.elementAt(0).toString()));
        d.setY_ballon(Double.valueOf (message.elementAt(1).toString()));
        d.setTour(Integer.valueOf(message.elementAt(2).toString())) ;
        d.setTire1(Integer.valueOf(message.elementAt(3).toString())) ;
        
       // d.setTire1(Integer.valueOf(message.elementAt(3).toString())) ;
        jeu.setContentPane(d);
        jeu.setVisible(true);
        }
    }
    
}