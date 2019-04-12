package java_multi_thread_programming.c1.s11;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            t.setDaemon(true);
            t.start();
            Thread.sleep(5000);
            System.out.println("离开主线程就不打印了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
