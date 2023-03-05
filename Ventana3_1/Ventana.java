import javax.swing.*;
import java.awt.event.*;
public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }

    private void initValues(){
        String [] imagen = {"imagenes/mario1.png", "imagenes/mario1_v.png", "imagenes/mario2.png", "imagenes/mario2_v.png"};
        String [] sprite = {"imagenes/background.png", "imagenes/background_1.png"};
        JLabel Wall = new JLabel();
        Background bg = new Background(sprite);
        JButton btnStart = new JButton("Start");
        Animacion an = new Animacion(imagen, bg);

        an.setBounds(5, 19, 42, 42);
        an.Mario = an;
        Wall.setBounds(0, 20, 75, 25);
        an.Wall = Wall;
        bg.setBounds(0, 0,510,72);
        btnStart.setBounds(19, 75, 75, 25);

        btnStart.setFocusable(false);
        an.setFocusable(true);
        
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                btnStart.setEnabled(false);
                Thread t = new Thread(an);
                t.start();
            }// end actionmPerformed
        };

        an.addKeyListener(an);
        
        add(btnStart);
        add(an);
        add(Wall);
        add(bg);

        btnStart.addActionListener(listener);

        setTitle("Ventana 3");
        setSize(300,150);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
