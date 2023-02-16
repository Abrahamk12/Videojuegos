import javax.swing.*;
import java.awt.event.*;
public class Imagen2 extends JLabel implements Runnable, KeyListener{
    ImageIcon icon;
    String [] imagen;
    int x = 10, y, velozidad = 1, descenso = 0;
    private boolean estatus = false, derecha = true, arriba = false, correr = false, caminar = false;
    
    public Imagen2(String imagen[], int y){
        this.y = y;
        this.imagen = imagen;
        icon = new ImageIcon(this.getClass().getResource(imagen[2]));
        setIcon(icon);
    }
    public void run(){
        estatus = true;
        
        while(true){
            try{
                Thread.sleep(150);
                if((derecha == true) && (caminar == true)){
                    caminard();
                }else if(caminar == true){
                    caminari();
                }
                if((derecha == true) && (correr == true)){
                    correrd();
                }else if((derecha == false) && (correr == true)){
                    correrd();
                }
            }catch(Exception e){}
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(estatus == true){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                derecha = true;
                caminar = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                derecha = false;
                caminar = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                correr = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){
                arriba = true;
            }
       }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(estatus == true){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                caminar = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                caminar = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                correr = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){
                arriba = false;
            }
       }

    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void caminard(){
        if((x % 2 != 0)){
            icon = new ImageIcon(this.getClass().getResource(imagen[0]));
            x++;
            setIcon(icon);
            setLocation(x, y);
        }else{
            icon = new ImageIcon(this.getClass().getResource(imagen[2]));
            x++;
            setIcon(icon);
            setLocation(x, y);
        }
        
    }

    void caminari(){
        if((x % 2 != 0)){
            icon = new ImageIcon(this.getClass().getResource(imagen[3]));
            x--;
            setIcon(icon);
            setLocation(x, y);
            }else{
                icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                x--;
                setIcon(icon);
                setLocation(x, y);
            }
    }

    public void correrd(){
        if(derecha == true){
            if((x % 2 != 0)){
                icon = new ImageIcon(this.getClass().getResource(imagen[0]));
                x+=5;
                setIcon(icon);
                setLocation(x, y);
            }else{
                icon = new ImageIcon(this.getClass().getResource(imagen[2]));
                x+=5;
                setIcon(icon);
                setLocation(x, y);
            }
        }else{
            if((x % 2 != 0)){
                icon = new ImageIcon(this.getClass().getResource(imagen[3]));
                x-=5;
                setIcon(icon);
                setLocation(x, y);
            }else{
                icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                x-=5;
                setIcon(icon);
                setLocation(x, y);
            }
        }
    
    }
    
    public void brincar(){
        while(descenso != 1){
            if(descenso == 1){
                y++;
                x++;
                icon = new ImageIcon(this.getClass().getResource(imagen[2]));
                setIcon(icon);
                setLocation(x, y);
            }else{
                
            }
        }
    }
    
}
