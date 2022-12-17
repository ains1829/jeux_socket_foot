package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
import java.net.InetAddress;
import dessin.*;
public class SocketServer {
    private static ServerSocket server;
    private static int port = 9898;
    private static Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    InetAddress host = InetAddress.getLocalHost();
    public SocketServer()throws  IOException {
        server = new ServerSocket(port);
    }
    public void waitAndAcceptAndTakeSocketClient()throws  IOException{
        System.out.println("miander7");
        this.socket = server.accept();
        ois = new ObjectInputStream(this.socket.getInputStream());
        oos = new ObjectOutputStream(this.socket.getOutputStream()) ;
    }
    public void sendToClient(Object obj , Socket sockets)throws  IOException{
        // System.out.println(socket);
        // System.out.println(socket.isClosed());
        // System.out.println(obj);
        this.oos.writeObject(obj);
    }
    public Object getObjectFromClient()throws  IOException, ClassNotFoundException{
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
