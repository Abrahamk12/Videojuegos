import javax.swing.*;
public class Etiqueta extends JLabel implements Runnable{
    private String txt1;
    public int time;
    JButton btnStart;
    public Etiqueta(){

    }
    public Etiqueta(String txt1, int time){
        this.txt1 = txt1;
        this.time = time;
    }
    public void run(){
        for(int i=0; i<10; i++){
            try{
                Thread.sleep(time);
                setText(Integer.toString(i));
            }catch(Exception e){}
        }btnStart.setEnabled(true);
    }//end run
}
