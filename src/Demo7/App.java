package Demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;
    public Processor (int id){
        this.id=id;
    }
    public void run(){
        System.out.println("starting:"+id);
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){

        }
        System.out.println("completed"+id);
    }

public static class App {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor= Executors.newFixedThreadPool(2);

        for(int i=0; i<5; i++){
            executor.submit(new Processor(i));
        }
        executor.shutdown();
        System.out.println("all tasks submitted.");
        try{
        executor.awaitTermination(1, TimeUnit.DAYS);



    }catch (InterruptedException E){

        }
       System.out.println("ALL TASKS COMpleted.");


}

    }
}
