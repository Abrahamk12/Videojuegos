import javax.swing.*;
import java.awt.event.*;
public class Imagen2 extends JLabel implements Runnable, KeyListener{
    ImageIcon icon, icon2;
    String [] imagen;
    String brackground;
    int x = 10, y, descenso = 0;
    private boolean estatus = false, derecha = true, arriba = false, correr = false, caminar = false;
    
    public Imagen2(String imagen[], int y, String brackground){
        this.y = y;
        this.imagen = imagen;
        this.brackground = brackground;
        icon2 = new ImageIcon(this.getClass().getResource(brackground));
        setIcon(icon2);
        icon = new ImageIcon(this.getClass().getResource(imagen[2]));
        setIcon(icon);
        
    }
    public void run(){
        estatus = true;
        while(true){
            try{
                Thread.sleep(150);
                if(caminar == true){
                    if(derecha == true){
                        caminard();
                    }else{
                        caminari();
                    }
                    if((derecha == true) && (correr == true)){
                        correr();
                    }else if((correr == true)){
                        correr();
                    }
                    if((derecha == true) && (arriba = true)){
                        brincoD();
                    }else if((arriba = true)){
                        brincoI();
                    }
                    if((derecha == true) && (correr == true) && (arriba = true)){
                        brincoRD();
                    }else if((correr == true) && (arriba = true)){
                        brincoRI();
                    }
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
                derecha = false;
                caminar = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                derecha = true;
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
    
    void caminard(){
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

    void correr(){
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
                icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                x-=5;
                setIcon(icon);
                setLocation(x, y);
            }else{
                icon = new ImageIcon(this.getClass().getResource(imagen[3]));
                x-=5;
                setIcon(icon);
                setLocation(x, y);
            }
        }
    
    }
    
    void brincoD(){
        if(caminar == true){
            icon = new ImageIcon(this.getClass().getResource(imagen[0]));
                setIcon(icon);
                if(descenso == 0){
                    if(y != 230){
                        x++;
                        y--;
                        setLocation(x, y);
                    }else{
                        descenso = 1;
                    }
                    
                }else if(descenso == 1){
                    icon = new ImageIcon(this.getClass().getResource(imagen[0]));
                    if(y != 240){
                        x++;
                        y++;
                        setIcon(icon);
                        setLocation(x, y);
                    }
                }
        }
    }
    void brincoI(){
        if(caminar == true){
            icon = new ImageIcon(this.getClass().getResource(imagen[1]));
            setIcon(icon);
            if(descenso == 0){
                if(y != 230){
                    x--;
                    y--;
                    setLocation(x, y);
                }else{
                    descenso = 1;
                }
                
            }else if(descenso == 1){
                icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                if(y != 240){
                    x--;
                    y++;
                    setIcon(icon);
                    setLocation(x, y);
                }
            }
            
        }
    }

    void brincoRD(){
        if(arriba == true){
            if(descenso == 0){
                icon = new ImageIcon(this.getClass().getResource(imagen[0]));
                setIcon(icon);
                if(y != 230){
                    x+=5;
                    y--;
                    setLocation(x, y);
                }else{
                    descenso = 1;
                }
                
            }else if(descenso == 1){
                icon = new ImageIcon(this.getClass().getResource(imagen[0]));
                if(y != 240){
                    x+=5;
                    y++;
                    setIcon(icon);
                    setLocation(x, y);
                }
            }
        
        }
    }
    void brincoRI(){
        if(arriba == true){
            if(descenso == 0){
                icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                setIcon(icon);
                if(y != 230){
                    x-=5;
                    y--;
                    setLocation(x, y);
                }else{
                    descenso = 1;
                }
                
            }else if(descenso == 1){
                icon = new ImageIcon(this.getClass().getResource(imagen[1]));
                setIcon(icon);
                if(y != 240){
                    x-=5;
                    y++;
                    setLocation(x, y);
                }
            }
            
        }
    }
}
