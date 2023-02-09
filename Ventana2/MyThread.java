import javax.swing.*;
public class MyThread extends Thread{
    JLabel texto1;
    JButton btnStart;

    public void run(){
        int contador = 0, i = 10;
        boolean derecha = false;
        
        while(true){
            try{
                Thread.sleep(7);
                texto1.setText(Integer.toString(contador));
                texto1.setLocation(i, 10);
                
                if(i == 200){
                    contador++;
                    texto1.setText(Integer.toString(contador));
                    derecha = true;
                }else if(i == 10){
                    contador++;
                    texto1.setText(Integer.toString(contador));
                    derecha = false;
                }
                if(derecha == true){
                    i--;
                }else{
                    i++;
                }
                
            }catch(Exception e){}
        }
    }//end run
}
