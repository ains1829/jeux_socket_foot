package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.util.*;
import dessin.*;
public class ClientSocket {
    String host ;  
    Socket socket;
    int portServer;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    public ClientSocket(String host,int port)throws  IOException{
        this.host = host;
        portServer=port;
    }
    public void seConnecterToServer()throws  IOException{
        socket = new Socket(host,this.portServer);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        System.out.println(socket);
        System.out.println("Connecter") ;
    }
    public void sendToServer(Object obj)throws  IOException{
        if(socket.isClosed()==true){    
            System.out.println("servor") ;
            this.seConnecterToServer();     
        }
        System.out.println(socket);
        this.oos.writeObject(obj);
    }
    public Object getObjectFromServer()throws  IOException, ClassNotFoundException{  
        Object obj=this.ois.readObject(); 
        return obj;
    }

    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
