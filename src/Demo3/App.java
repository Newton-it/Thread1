package Demo3;

public class App {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable(){
            public void run() {
                for(int i =0; i<10; i++){
                    System.out.println("kaysar"+i);
                    try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
    }
}





