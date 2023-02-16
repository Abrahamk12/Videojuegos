import javax.swing.*;
import java.awt.event.*;
public class Imagen2 extends JLabel implements Runnable, KeyListener{
    ImageIcon icon;
    String [] imagen;
    int x = 10, y, velozidad = 1;
    private boolean estatus = false, derecha = true, correr = false, caminar = false;
    
    public Imagen2(String imagen[], int y){
        this.y = y;
        this.imagen = imagen;
        icon = new ImageIcon(this.getClass().getResource(imagen[2]));
        setIcon(icon);
    }
    public void run(){
        estatus = true;
        /*
        while(true){
            if((derecha == true) && (caminar == true)){
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
            }else{
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
            if((derecha == true) && (correr == true)){
                if((x % 2 != 0)){
                    icon = new ImageIcon(this.getClass().getResource(imagen[3]));
                    x+=2;
                    setIcon(icon);
                    setLocation(x, y);
                }
            }else if((derecha == false) && (correr == true)){
                if((x % 2 != 0)){
                    icon = new ImageIcon(this.getClass().getResource(imagen[3]));
                    x-=2;
                    setIcon(icon);
                    setLocation(x, y);
                }
            }
        }*/
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(estatus == true){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                caminard();
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                caminari();
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                correrd();
            }
       }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(estatus == true){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                derecha = false;
                caminar = false;
                //caminard();
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                derecha = true;
                caminar = false;
                //caminari();
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                correr = false;
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

    public void caminari(){
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

    }
    
}
