public class HiloHijo1 extends Thread{

    String name; 
    int tiempo;

    public void setNombre(String name){
        this.name = name;
    }

    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }

    public void run(){
            System.out.println("Hilo:"+name+""+Thread.currentThread());
            for(int i = 1; i <= 10; i++){
                try{
                    System.out.println(i+"["+name+"]");
                    Thread.sleep(tiempo);
                }catch(Exception e){}
            }
    }
}