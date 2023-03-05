import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Background extends JLabel{
    private String[] sprite;
    private ImageIcon icon;

    public Background(String[] sprite){
        this.sprite = sprite;

        //Icon
        icon = new ImageIcon(this.getClass().getResource(sprite[0]));
        setIcon(icon);
    }
    //Movimiento de la imagen
    public void mover_fondo(int x){
        if(this.getX() != 110){
            icon = new ImageIcon(this.getClass().getResource(sprite[(int) Math.random()]));
            setIcon(icon);
            setBounds(this.getX() - x, 0, 510, 72);
        }
        //Movemos el fondo
        setBounds(this.getX() - x, 0, 510, 72);
    }

    public ImageIcon getIcon(){
        return this.icon;
    }
}
