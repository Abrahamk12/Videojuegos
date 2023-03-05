public class HiloHijoT2 implements Runnable{
    private String name;
    private int time;

    public void setNombre(String name){
        this.name = name;
    }

    public void setTime(int time){
        this.time = time;
    }
    public void run(){
        for(int i=0; i<10; i++){
            try{
                System.out.print("Hilo [" + name + "]: ");
                Thread.sleep(time);
            }catch(Exception e){

            }
        }
    }//end run
}
