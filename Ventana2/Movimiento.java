import javax.swing.*;
public class Movimiento extends JLabel implements Runnable {
    JButton btnStart;
    String txt;
    public Movimiento(String txt){
        this.txt = txt;
    }
    public void run(){
        int contador = 0, i = 10;
        boolean derecha = false;
        
        while(true){
            try{
                Thread.sleep(7);
                setText(Integer.toString(contador));
                setLocation(i, 10);
                
                if(i == 200){
                    contador++;
                    setText(Integer.toString(contador));
                    derecha = true;
                }else if(i == 10){
                    contador++;
                    setText(Integer.toString(contador));
                    derecha = false;
                }
                if(derecha == true){
                    i--;
                }else{
                    i++;
                }
            }catch(Exception e){}
        }
        
    }
}
