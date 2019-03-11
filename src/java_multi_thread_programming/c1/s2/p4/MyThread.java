package java_multi_thread_programming.c1.s2.p4;

public class MyThread extends Thread {
    private int i = 5;
    @Override
    public void run() {
        // 虽然print方法的内部是同步的
        // 但是i--的操作是在进入print之前发生的
        System.out.println("i = " + (i--) + " threadName = " + Thread.currentThread().getName());
    }
}
