package dessin;
public class Menu{
    public static void main(String[] args) {
        try {
            new FrameToConnect() ; 
        } catch (Exception e) {
            e.printStackTrace() ;
            // TODO: handle exception
        }
    }
}