import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.geom.*;
public class Mario extends JLabel{
    private String [] spritesMario = {"imagenes/mario1.png", "imagenes/mario1_v.png", "imagenes/mario2.png", "imagenes/mario2_v.png"};
    private ImageIcon marioIcon;
    int posX, posY, power, presion;
    Background background;
    Platform platform;
    Block block;

    public Mario(Platform platform, Block block, Background background){
        this.background = background;
        this.platform = platform;
        this.block = block;
        this.marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[0]));
        setIcon(marioIcon);
    }
    public void moveMario(int posX, int posY, int power){
        this.posX = posX;
        this.posY = posY;
        this.power = power;
        if((this.posX % 2 != 0)){
            marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[0]));
            if(this.posX != 115){
                setIcon(marioIcon);
                setLocation(this.posX += this.power, this.posY);
            }else{
                setIcon(marioIcon);
                background.move_backround(this.power);
                platform.movePlatform(this.power);
                block.moveBlock(this.power);
            }
            
        }else{
            marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[2]));
            if(this.posX != 115){
                setIcon(marioIcon);
                setLocation(this.posX += this.power, this.posY);
            }else{
                
                setIcon(marioIcon);
                background.move_backround(this.power);
                platform.movePlatform(this.power);
                block.moveBlock(this.power);
            }
        }
    }
    public void jump(int posX, int posY, int power){
        this.posX = posX;
        this.posY = posY;
        this.power = power;
        int up = this.posY -= power;
        if(up != 0){
            try{
                Thread.sleep(50);
                if((this.posX % 2 != 0)){
                    marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[0]));
                    if(this.posX != 115){
                        setIcon(marioIcon);
                        setLocation((this.posX += this.power), up);
                    }else{
                        setIcon(marioIcon);
                        background.move_backround(this.power);
                        platform.movePlatform(this.power);
                        block.moveBlock(this.power);
                    }
                    
                }else{
                    marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[2]));
                    if(this.posX != 115){
                        setIcon(marioIcon);
                        setLocation((this.posX += this.power), up);
                    }else{
                        setIcon(marioIcon);
                        background.move_backround(this.power);
                        platform.movePlatform(this.power);
                        block.moveBlock(this.power);
                    }
                }
            }catch(Exception ex){}
        }else{
            gravity(10, 10);
        }
        
    }

    public void gravity(int time, int presion){
        this.presion = getY() + presion;
        try {
            Thread.sleep(time);
            if((this.posX % 2 != 0)){
                marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[0]));
                if(this.posX != 115){
                    setIcon(marioIcon);
                    setLocation(getX(), this.presion);
                }else{
                    setIcon(marioIcon);
                    background.move_backround(this.power);
                    platform.movePlatform(this.power);
                    block.moveBlock(this.power);
                }
            }else{
                marioIcon = new ImageIcon(this.getClass().getResource(this.spritesMario[2]));
                if(this.posX != 115){
                    setIcon(marioIcon);
                    setLocation(getX(), this.presion);
                }else{
                    setIcon(marioIcon);
                    background.move_backround(this.power);
                    platform.movePlatform(this.power);
                    block.moveBlock(this.power);
                }
            }
            
            
        } catch (Exception e) { }
    }
    
    public boolean collisionBlock(){
        Area mario = new Area(this.getBounds());
        Area block = new Area(this.block.getBounds());

        return block.intersects(mario.getBounds());
    }

    public boolean collisionPLatform(){
        Area mario = new Area(this.getBounds());
        Area platform = new Area(this.platform.getBounds());
        return platform.intersects(mario.getBounds());
    }

    public boolean restartPosition(){
        if(this.getY() > 170){
            setLocation(5, 15);
        }else if(this.getX() == 0){
            setLocation(5, 15);
        }
        return true;
    }

    void backMario(int posX, int posY, int power){
        this.posY = posY;
        posX -= power;
        setLocation(posX, posY);
        gravity(10, 20);
    }
}