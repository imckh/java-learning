package java_multi_thread_programming.c1.s10.p2_regular;

public class Run {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
        // 线程优先级具有继承性
            MyThread1 t1 = new MyThread1();
            t1.setPriority(10);
            t1.start();
            MyThread2 t2 = new MyThread2();
            t2.setPriority(1);
            t2.start();
        }
    }
}
