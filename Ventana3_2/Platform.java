import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Platform extends JLabel{
    private String spritePlatform = "imagenes/platform.png";
    private ImageIcon platformIcon;
    int posX;
    public Platform(){
        this.platformIcon = new ImageIcon(this.getClass().getResource(spritePlatform));
        setIcon(platformIcon);
    }

    public void movePlatform(int posX){
        this.posX = posX;
        if(this.getX() != 110){
            setIcon(platformIcon);
            setBounds(this.getX() - posX, 55, 161, 15);
        }
        setBounds(this.getX() - posX, 55, 161, 15);
    }

}
