import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Animacion extends JLabel implements Runnable, KeyListener{
    private boolean startGame = false, jump = false, run = false, walk = false, down = false, collision = false;
    private int posX = 10, posY = 20;
    private Background background;
    private String [] sprites;
    private ImageIcon icon, icon2;
    JLabel Mario, Wall;
    JButton btnstar;

    public Animacion(String sprites[], Background background){
        this.sprites = sprites;
        this.background = background;
        icon = new ImageIcon(this.getClass().getResource(sprites[2]));
        setIcon(icon);
        icon2 = new ImageIcon(this.getClass().getResource("imagenes/wall.png"));
        Wall.setIcon(icon2);
    }
    public void run(){
        this.startGame = true;
        while(true){

            try{
                Thread.sleep(50);
                if(this.startGame){
                    if(this.walk){
                        walk();
                    }
                    if(this.jump){
                        jump();
                    }
                    if(this.walk && this.jump){
                        jumpWalk();
                    }
                    if(this.walk && this.run){
                        running();
                    }
                    if(this.walk && this.jump && this.run){
                        jumpRun();
                    }
                    if(collision){
                        
                    }else{
                        gravity();
                    }
                }
            }catch(Exception ex){}
            
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(startGame){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){ 
                this.walk = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_CONTROL){ this.run = true; }
            if(e.getKeyCode() == KeyEvent.VK_UP){ this.jump = true; }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){ 
            this.walk = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){ this.run = false; }
        if(e.getKeyCode() == KeyEvent.VK_UP){ this.jump = false; }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    void walk(){
        this.posX++;
        if((this.posX % 2 != 0)){
            if(this.getX() != 125){
                icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                setIcon(icon);
                setLocation(this.posX, this.posY);
            }else{
                icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                setIcon(icon);
                background.mover_fondo(this.posX);
            }
            
        }else{
            
            if(this.getX() != 125){
                icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                setIcon(icon);
                setLocation(this.posX, this.posY);
            }else{
                icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                setIcon(icon);
                background.mover_fondo(this.posX);
                
            }
        }
        
    }

    void running(){
        this.posX+=4;
        if((this.posX % 2 != 0)){
           
            if(this.getX() != 125){
                icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                setIcon(icon);
                setLocation(this.posX, this.posY);
            }else{
                icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                setIcon(icon);
                background.mover_fondo(this.posX);
            }
            
        }else{
            
            if(this.getX() != 125){
                icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                setIcon(icon);
                setLocation(this.posX, this.posY);
            }else{
                icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                setIcon(icon);
                background.mover_fondo(this.posX);
            }
        }
        
    }

    void jump(){
        while(jump){
            if(this.posY > 0){
                this.posY--;
                try{
                    Thread.sleep(100);
                    if((this.posX % 2 != 0)){
                        icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                        setIcon(icon);
                        setLocation(this.posX, this.posY);
                    }else{
                        icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                        setIcon(icon);
                        setLocation(this.posX, this.posY);
                    }
                }catch(Exception ex){}
                if(this.posY == 0){
                    this.down = true;
                }
            }
            
        }

    }

    void jumpWalk(){
        while(jump){
            this.posX++;
            if(this.posY > 0){
                this.posY--;
                if(this.getX() != 150){
                    try{
                        Thread.sleep(50);
                        if((this.posX % 2 != 0)){
                            icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                            setIcon(icon);
                            setLocation(this.posX, this.posY);
                        }else{
                            icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                            setIcon(icon);
                            setLocation(this.posX, this.posY);
                        }
                    }catch(Exception ex){}
                }else{
                    if((this.posX % 2 != 0)){
                        icon = new ImageIcon(this.getClass().getResource(sprites[0]));
                        setIcon(icon);
                        setLocation(this.posX, this.posY);
                    }else{
                        icon = new ImageIcon(this.getClass().getResource(sprites[2]));
                        setIcon(icon);
                        setLocation(this.posX, this.posY);
                    }
                    background.mover_fondo(this.getX());
                }
                
                if(this.posY == 0){
                    this.down = true;
                }
            }              
        }
    }

    void jumpRun(){

    }

    boolean collision(){
        //Area Mario = new Area(Mario.getBounds());
        //Area Wall = new Area(this.getBounds());
        return true;//Wall.intersects(Mario.getBounds2D());
    }
    void gravity(){
        posY++;
        this.setLocation(this.getX(), this.posY);
    }
}
