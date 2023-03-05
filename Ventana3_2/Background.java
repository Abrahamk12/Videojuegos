import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Background extends JLabel{
    private String spriteBackgroud = "imagenes/background.png";
    private ImageIcon backgroundIcon;
    int posX;
    public Background(){
        this.backgroundIcon = new ImageIcon(this.getClass().getResource(spriteBackgroud));
        setIcon(backgroundIcon);
    }
    public void move_backround(int posX){
        this.posX = posX;
        if(this.getX() != 110){
            setIcon(backgroundIcon);
            setBounds(this.getX() - posX, 0, 510, 72);
        }
        setBounds(this.getX() - 1, 0, 510, 72);
    }
}
