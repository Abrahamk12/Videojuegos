import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    private void initValues(){
        String [] imagen = {"imagenes/mario1.png", "imagenes/mario1_v.png", "imagenes/mario2.png", "imagenes/mario2_v.png"};
        String [] imagen1 = {"imagenes/link1.png", "imagenes/link1_v.png", "imagenes/link2.png", "imagenes/link2_v.png"};
        Imagenes img1 = new Imagenes(imagen, 40, 10);
        Imagenes img2 = new Imagenes(imagen1, 80, 20);
        JButton btnStart = new JButton("Start");

        img1.setBounds(10, 40, 42, 42);
        img2.setBounds(10, 80, 42, 42);
        btnStart.setBounds(19, 10, 75, 25);

        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                Thread t = new Thread(img1);
                Thread t1 = new Thread(img2);
                t.start();
                t1.start();
            }// end actionmPerformed
        };

        btnStart.addActionListener(listener);
        add(btnStart);
        add(img1);
        add(img2);

        setTitle("Ventana 3");
        setSize(300,300);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
