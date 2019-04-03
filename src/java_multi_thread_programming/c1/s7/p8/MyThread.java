package java_multi_thread_programming.c1.s7.p8;

public class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了");
                return; // 使用return
            }
            System.out.println("time = " + System.currentTimeMillis());
        }
    }
}
