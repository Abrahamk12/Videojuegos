import javax.swing.JLabel;
public class counterLife extends JLabel{
    int life = 3;
    public void subtractLife(){
        System.out.println("La perra vida: " + life);
        life--;
        setText(Integer.toString(life));
    }
}
