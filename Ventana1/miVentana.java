import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
public class miVentana extends JFrame{
    public miVentana(){
        initValues();
    }//end Ventana
    
    private void initValues(){
        Font font1 = new Font("Arial", 1, 24);
        Etiqueta texto1 = new Etiqueta("0", 500);
        Etiqueta texto2 = new Etiqueta("0", 10000);
        texto1.setFont(font1);
        texto1.setBounds(10,10,50, 25);
        texto2.setFont(font1);
        texto2.setBounds(10,40,50, 25);
        add(texto1);
        add(texto2);

        setTitle("Mi ventana");
        setSize(300,300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JButton button = new JButton("Button");
        button.setBounds(10,100,75,25);
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent ae1){
                System.out.print("Me diste click");
                texto1.btnStart = button;
                button.setEnabled(false);
                Thread t1 = new Thread(texto1);
                Thread t2 = new Thread(texto2);
                t1.start();
                t2.start();
            }
        };
        button.addActionListener(listener);
        add(button);
        
        
    }//end initValues
}
