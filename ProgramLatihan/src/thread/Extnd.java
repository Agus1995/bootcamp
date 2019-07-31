package thread;

public class Extnd extends Thread {
    public Extnd(String ab){
        super(ab);
    }

    public void run(){
        coba();
    }

    public void coba(){
 //       System.out.println("prosessssssssss");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
