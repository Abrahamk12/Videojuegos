import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Block extends JLabel{
    private String spriteBlock = "imagenes/block.png";
    private ImageIcon blockIcon;
    int posX;

    public Block(){
        this.blockIcon = new ImageIcon(this.getClass().getResource(spriteBlock));
        setIcon(blockIcon);
    }
    public void moveBlock(int posX){
        this.posX = posX;
        if(this.getX() != 110){
            setIcon(blockIcon);
            setBounds(this.getX() - posX, 0, 510, 72);
            //newBlock();
        }
        setBounds(this.getX() - posX, 0, 510, 72);
    }
    public void newBlock(){
        while(true){
            try{
                Thread.sleep(10);
                if(this.getX() != 110){
                    new Block().setBounds(this.getX() - posX, ( (int) (Math.random() * (55 - 0) ) + 0), 510, 72);
                }
                new Block().setBounds(this.getX() - posX, ( (int) (Math.random() * (55 - 0) ) + 0), 510, 72);
            }catch(Exception ex){}
        }
    }
}
