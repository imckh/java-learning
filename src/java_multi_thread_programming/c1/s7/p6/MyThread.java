package java_multi_thread_programming.c1.s7.p6;

public class MyThread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("进入了catch");
            e.printStackTrace();
        }
    }
}
