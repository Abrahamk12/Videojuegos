import javax.swing.*;
import java.awt.event.*;

public class LabelKey extends JLabel implements Runnable {
    int i = 10;
    public LabelKey(String texto){
        setText(texto);
    }
    public void run(){
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent ke){}

            public void KeyPressed(KeyEvent ke){
                if((ke.getKeyCode() == KeyEvent.VK_RIGHT) && (i <= 299)){
                    i++;
                    //setLocation(i, 10);
                    setBounds(i,10,50,25);
                }
                if((ke.getKeyCode() == KeyEvent.VK_LEFT) && (i >= 10)){
                    i--;
                    //setLocation(i, 10);
                    setBounds(i,10,50,25);
                }
            }//end KeyPressed

            public void keyReased(KeyEvent ke){}

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
    }//end run
}
