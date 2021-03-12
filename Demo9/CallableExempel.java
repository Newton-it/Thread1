package Demo9;
import java.util.concurrent.Callable;


public class CallableExempel implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 1+1;
    }
}

