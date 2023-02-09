import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    private void initValues(){
        Font font1 = new Font("Arial", 1, 22);
        //JLabel texto1 = new JLabel("0");//hacer que el label rebote
        LabelKey lkey = new LabelKey("0");
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(10,80,75,24);
        
        //texto1.setFont(font1);
        lkey.setBounds(10,40,50,25);
        lkey.setFont(font1);
        //add(texto1);

        Movimiento mov = new Movimiento("0");
        mov.setFont(font1);
        mov.setBounds(10,10,50,25);
        add(mov);

        lkey.setFocusable(true);
        btnStart.setFocusable(false);

        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                //MyThread t = new MyThread();
                Thread tkey = new Thread(lkey);
                Thread t = new Thread(mov);

                mov.btnStart = btnStart;
                btnStart.setEnabled(false);

                t.start();
                tkey.start();
            }// end actionmPerformed
        };

        btnStart.addActionListener(listener);
        //add(texto1);
        add(btnStart);
        add(lkey);
        
        setTitle("Ventana 2");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end initValues
}
