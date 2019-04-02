package java_multi_thread_programming.c1.s7.p1;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
            // 并没有停止线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
