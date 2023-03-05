import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame{
    
    public Ventana(){
        initValues();
    }
    private void initValues(){
        Platform platform = new Platform();
        Block block = new Block();
        Background background = new Background();
        counterLife life = new counterLife();
        Mario mario = new Mario(platform, block, background);
        Animation animation = new Animation(mario, life);
        JButton btnStar = new JButton("Start");
    
        life.setText("3");

        btnStar.setBounds(5, 85, 75, 25);
        animation.setBounds(5, 85, 75, 200);
        background.setBounds(0, 0, 510, 72);
        mario.setBounds(5, 15, 42, 42);
        platform.setBounds(0, 55, 161, 15);
        block.setBounds(300, 10, 16, 16);
        life.setBounds(270, 0, 25,25);

        btnStar.setFocusable(false);
        animation.setFocusable(true);

        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                btnStar.setEnabled(false);
                Thread thread = new Thread(animation);
                thread.start();
            }// end actionmPerformed
        };

        animation.addKeyListener(animation);
        btnStar.addActionListener(listener);

        //add the components to the window
        add(life);
        add(mario);
        add(platform);
        add(block);
        add(background);
        add(animation);
        add(btnStar);
        

        setTitle("Ventana 3");
        setSize(300,150);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end init Values
}
