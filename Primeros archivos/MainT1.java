public class MainT1 {
    public static void main(String[] args){
        HiloHijoT2 ht2 = new HiloHijoT2();
        ht2.setNombre("Miguelon");
        ht2.setTime(500);

        Thread t1 = new Thread(ht2);
        t1.start();

        HiloHijoT2 htt2 = new HiloHijoT2();
        htt2.setNombre("Prueba");
        htt2.setTime(5000);

        Thread t2 = new Thread(htt2);
        t2.start();
    }
}
