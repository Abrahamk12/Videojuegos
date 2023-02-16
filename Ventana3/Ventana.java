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
        Imagen2 iimg2 = new Imagen2(imagen1, 240);
        JButton btnStart = new JButton("Start");

        img1.setBounds(10, 40, 42, 42);
        img2.setBounds(10, 80, 42, 42);
        iimg2.setBounds(10, 240, 42, 42);
        btnStart.setBounds(19, 10, 75, 25);
        
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                Thread t = new Thread(img1);
                Thread t1 = new Thread(img2);
                Thread t2 = new Thread(iimg2);
                t.start();
                t1.start();
                t2.start();
            }// end actionmPerformed
        };

        add(btnStart);
        add(img1);
        add(img2);
        add(iimg2);
        
        btnStart.addActionListener(listener);
        iimg2.addKeyListener(iimg2);

        btnStart.setFocusable(false);
        iimg2.setFocusable(true);

        setTitle("Ventana 3");
        setSize(780,350);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
