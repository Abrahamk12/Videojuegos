import javax.swing.*;
public class Movimiento extends JLabel implements Runnable {
    JButton btnStart;
    String txt;
    public Movimiento(String txt){
        this.txt = txt;
    }
    public void run(){
        int contador = 0, i = 10;
        
        while(true){
            try{
                setText(Integer.toString(contador));
                setHorizontalTextPosition(i);
                i++;
                if(i == 280){
                    contador++;
                    setText(Integer.toString(contador));
                }
                if(contador == 10){
                    btnStart.setEnabled(true);
                }
            }catch(Exception e){}
        }
        
    }
}
