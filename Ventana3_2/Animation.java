import javax.swing.*;
import java.awt.event.*;
public class Animation extends JLabel implements Runnable, KeyListener{
    private boolean startGame = false, walk = false, jump = false, run = false;
    Platform platform;
    counterLife life;
    Mario mario;
    Block block;

    int posX = 5, posY = 20;
    JButton btnStart;

    public Animation(Mario mario, counterLife life){ 
        this.mario = mario;
        this.life = life;
    }

    public void run(){
        this.startGame = true;

        while(true){
            try{

                Thread.sleep(50);

                if(this.startGame){
                    
                    if(this.walk){
                        mario.moveMario(mario.getX(), mario.getY(), 1);
                    }
                    if(this.jump){
                        mario.jump(mario.getX(), mario.getY(), 1);
                    }else if(this.jump && this.walk){
                        mario.jump(mario.getX(), mario.getY(), 1);
                    }
                    if(this.run){
                        mario.moveMario(mario.getX(), mario.getY(), 4);
                    }
                    if(this.jump && this.run){
                        mario.jump(mario.getX(), mario.getY(), 4);
                    }
                    if(mario.collisionBlock()){
                        mario.backMario(mario.getX(), mario.getY(), 1);
                    }else if(mario.collisionBlock() && this.jump){
                        mario.backMario(mario.getX(), mario.getY(), 4);
                    }else if(mario.collisionPLatform()){
                        
                    }else if(!jump){
                        mario.gravity(10, 20);
                    }
                    if(mario.getY() == 180){
                        if(life()){ break; }
                    }
                    
                }
            }catch(Exception ex){}
        }//end while

    }// end run

    @Override
    public void keyPressed(KeyEvent e) {
        if(startGame){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){ this.walk = true; }
            if(e.getKeyCode() == KeyEvent.VK_CONTROL){ this.run = true; }
            if(e.getKeyCode() == KeyEvent.VK_UP){ this.jump = true; }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){ this.walk = false; }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){ this.run = false; }
        if(e.getKeyCode() == KeyEvent.VK_UP){ this.jump = false; }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    boolean life(){
        if(mario.restartPosition()){life.subtractLife(); }
        if(life.life == 0){ return true; }
        return false;
    }
    
}
