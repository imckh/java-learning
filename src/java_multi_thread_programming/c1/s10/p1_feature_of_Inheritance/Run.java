package java_multi_thread_programming.c1.s10.p1_feature_of_Inheritance;

public class Run {
    public static void main(String[] args) {
        // 线程优先级具有继承性
        System.out.println("Main begin Priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("Main end Priority = " + Thread.currentThread().getPriority());
        MyThread1 t1 = new MyThread1();
        t1.start();
    }
}
