public class Main{
    public static void main(String[] args){
        Thread t = Thread.currentThread();
        System.out.println("Hilo Actual: " + t);
        System.out.println("Hilo Actual: " + Thread.currentThread());

        HiloHijo1 h1 = new HiloHijo1();
        //h1.name = "H1";
        h1.start();
        HiloHijo1 h2 = new HiloHijo1();
        //h1.name = "H1";
        h2.start();
        /*
        HiloHijo1 h2 = new HiloHijo1("H2");
        //h2.name = "H2";
        h2.start();
        try{
            System.out.print("Esperando a finalizar...");
            
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            
            for(int i = 0; i < 7; i++){
                Thread.sleep(1000);
                System.out.print(".");
            }
            System.out.println("\nAdios");
        }catch(Exception e){

        }*/
        
    }
}