package dessin;
import java.awt.*;
import javax.swing.*;
import listener.*;
public class FrameToConnect extends JFrame{
    JTextField host ;
    JTextField port ;
    JButton connected;
    JButton local;
    public JTextField getHost(){
        return host ;
    }
    public JTextField getPort(){
        return port ;
    }
    public JButton getConnected(){
        return connected ;
    }
    public JButton getLocal(){
        return local ;
    }
    public FrameToConnect(){
        this.setTitle("Connected To server") ;
        JLabel label = new JLabel("WELCOME") ;
        JPanel panel = new JPanel() ;
        panel.setLayout(null) ;
        JLabel tagHost = new JLabel("HOST :") ;
        JLabel tagPort = new JLabel("PORT :") ;
        connected = new JButton("En ligne") ;
        local = new JButton("Local") ;
        label.setFont(new Font("Serif" , Font.ITALIC,30));
        label.setForeground(Color.yellow);

        tagHost.setFont(new Font("Serif" , Font.ITALIC,20));
        tagHost.setForeground(Color.white);

        tagPort.setFont(new Font("Serif" , Font.ITALIC,20));
        tagPort.setForeground(Color.white);
        label.setBounds(150,10,150,40) ;
        tagHost.setBounds(20,100,100,40) ;
        tagPort.setBounds(20,200,100,40) ;

        local.setBounds(80,300,150,40) ;
        local.setBackground(Color.green) ;
        local.addMouseListener(new ListenerToStart(this));

        connected.setBounds(260,300,150,40) ;
        connected.setBackground(Color.green) ;
        connected.addMouseListener(new ListenerToStart(this));
        host = new JTextField() ;
        port = new JTextField() ;
        host.setBounds(130,100,250,40) ;
        port.setBounds(130,200,250,40) ;
        panel.add(label) ;
        panel.add(host) ;
        panel.add(port) ;
        panel.add(tagHost);
        panel.add(tagPort);
        panel.add(connected) ;
        panel.add(local) ;
        panel.setBackground(Color.blue) ;
        this.add(panel) ;
        this.setSize(500,500) ;
        this.setVisible(true) ;
    }
}