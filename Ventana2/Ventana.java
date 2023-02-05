import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Ventana extends JFrame{
    public Ventana(){
        initValues();
    }
    private void initValues(){
        //MyThread t = new MyThread();
        Font font1 = new Font("Arial", 1, 22);
        //JLabel texto1 = new JLabel("0");//hacer que el label rebote
        Movimiento texto1 = new Movimiento("0");
        texto1.setFont(font1);
        texto1.setBounds(10,10,50,25);
        add(texto1);

        JButton btnStart = new JButton("Start");
        btnStart.setBounds(10,40,75,24);

        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                texto1.btnStart = btnStart;
                btnStart.setEnabled(false);
                Thread t = new Thread(texto1);
                t.start();
            }// end actionmPerformed
        };

        btnStart.addActionListener(listener);
        add(btnStart);
        
        setTitle("Ventana 2");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end initValues
}
