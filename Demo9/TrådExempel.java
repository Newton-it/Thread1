package Demo9;

public class TrådExempel implements Runnable {
    public static int räknare = 0;
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("räknare: " + räknare);
        räknare = räknare +1;
    }
}


