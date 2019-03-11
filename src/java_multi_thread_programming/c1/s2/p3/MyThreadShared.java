package java_multi_thread_programming.c1.s2.p3;

public class MyThreadShared extends Thread {
    private int count = 5;
    @Override
    public void run() {
        super.run();
        // 这里不能用for
        // 因为用for其他线程就得不到运行的机会了
        count--;
        System.out.println("由 " + currentThread().getName()
                + " 计算, count = " + count);
    }
}
