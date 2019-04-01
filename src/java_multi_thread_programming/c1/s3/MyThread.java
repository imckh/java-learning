package java_multi_thread_programming.c1.s3;

public class MyThread extends Thread {
    public MyThread() {
        System.out.println("构造方法: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法: " + Thread.currentThread().getName());
    }
}
