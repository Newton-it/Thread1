package Demo4;

import java.util.Scanner;

class Processor extends Thread{
    private boolean running =true;
    public void run(){
        while (true){
            System.out.println("turpan");

            try{
                Thread.sleep(100);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running=false;
    }
}


public class App {
    public static void main(String[] args) {
        Processor proc1= new Processor();
        proc1.start();
        System.out.println("press return to stop ....");
        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();


    }
}
