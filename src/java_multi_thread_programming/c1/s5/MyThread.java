package java_multi_thread_programming.c1.s5;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("this.currentThread().getName()  = " + this.currentThread().getName() + "begin");
            Thread.sleep(2000);
            System.out.println("this.currentThread().getName()  = " + this.currentThread().getName() + "end");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
