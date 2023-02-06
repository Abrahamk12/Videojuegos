import javax.swing.*;
public class MyThread extends Thread{
    JLabel texto1;
    JButton btnStart;

    public void run(){
        int contador = 0, i = 10;
        
        while(true){
            try{
                Thread.sleep(500);
                texto1.setText(Integer.toString(contador));
                texto1.setHorizontalTextPosition(i);
                i++;
                if(i == 200){
                    contador++;
                    texto1.setText(Integer.toString(contador));
                }
            }catch(Exception e){}
        }
    }//end run
}
