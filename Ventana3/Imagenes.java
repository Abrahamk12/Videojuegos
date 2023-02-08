import javax.swing.*;

public class Imagenes extends JLabel implements Runnable{
    ImageIcon icon;
    String [] imagen;
    int x = 10, y, time;
    boolean derecha = false;
    
    public Imagenes(String imagen[], int y, int time){
        this.y = y;
        this.time = time;
        this.imagen = imagen;
    }
    public void run(){
        /*
        for(int x=10; x <= 250; x++){
            if(x % 2 != 0){
                icon = new ImageIcon(this.getClass().getResource(url2));
            }else{
                icon = new ImageIcon(this.getClass().getResource(url));
            }
            
            try{
                Thread.sleep(200);
            }catch(Exception e){}
        }*/
        while(true){
            try{
                Thread.sleep(time);
                if(x == 250){
                    derecha = true;
                }else if(x == 10){
                    derecha = false;
                }
                if((x % 2 != 0) && (derecha == false)){
                    icon = new ImageIcon(this.getClass().getResource(imagen[2]));
                    x++;
                    setIcon(icon);
                    setLocation(x, y);
                }else if(derecha == false){
                    icon = new ImageIcon(this.getClass().getResource(imagen[0]));
                    x++;
                    setIcon(icon);
                    setLocation(x, y);
                }
                if((x % 2 != 0) && (derecha == true)){
                    icon = new ImageIcon(this.getClass().getResource(imagen[3]));
                    x--;
                    setIcon(icon);
                    setLocation(x, y);
                }else if(derecha == true){
                    icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                    x--;
                    setIcon(icon);
                    setLocation(x, y);
                }
                
                
            }catch(Exception e){};
        }
    }//end run
}
