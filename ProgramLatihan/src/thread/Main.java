package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    static Thread thread;
    public static void main(String[] args) {
       /* System.out.println(Thread.currentThread().getName());
        thread = new Thread(new New(), "terserah");
        thread.start();*/

       /* thread = new Thread(new Extnd(),"extend");
        thread.start();*/

       // System.out.println(Thread.currentThread().getName());

/*

        new Extnd("extnd1");//.start();
        new Extnd("extnd2");//.start();
        new Extnd("extnd3");//.start();
        new Extnd("extnd4");//.start();
        new Extnd("extnd5");//.start();
        new Extnd("extnd6");//.start();
        new Extnd("extnd7");//.start();
        new Extnd("extnd8");//.start();
        new Extnd("extnd9");//.start();
        new Extnd("extnd10");//.start();
*/

        ThreadPoolExecutor threadPoolExecutor ;

        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        threadPoolExecutor.submit(new Extnd("extnd1"));
        threadPoolExecutor.submit(new Extnd("extnd2"));
        threadPoolExecutor.submit(new Extnd("extnd3"));
        threadPoolExecutor.submit(new Extnd("extnd4"));
        threadPoolExecutor.submit(new Extnd("extnd5"));
        threadPoolExecutor.submit(new Extnd("extnd6"));
        threadPoolExecutor.submit(new Extnd("extnd7"));
        threadPoolExecutor.submit(new Extnd("extnd8"));
        threadPoolExecutor.submit(new Extnd("extnd9"));
        threadPoolExecutor.submit(new Extnd("extnd10"));

      //  threadPoolExecutor.getQueue().isEmpty()

        while (threadPoolExecutor.getQueue().size()>0){
            System.out.println(threadPoolExecutor.getActiveCount());
            try {
                thread.sleep(5000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}

