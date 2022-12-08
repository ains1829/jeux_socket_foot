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

public class SocketClient implements Serializable{

   public static void main(String[] args) throws ClassNotFoundException, IOException{
        InetAddress host = InetAddress.getLocalHost();
        ClientSocket cs = new ClientSocket(host.getHostName(),9898);
        cs.seConnecterToServer();
        Terrain jeu =  new Terrain() ;
        Dessin d = new Dessin(jeu , cs) ;
        while(true){
        Vector message = (Vector) cs.getObjectFromServer();
        d.setX_ballon(Double.valueOf (message.elementAt(0).toString()));
        d.setY_ballon(Double.valueOf (message.elementAt(1).toString()));
        // d.setTire1(Integer.valueOf(message.elementAt(3).toString())) ;
        jeu.setContentPane(d);
        jeu.setVisible(true);
        }
        
    }
}