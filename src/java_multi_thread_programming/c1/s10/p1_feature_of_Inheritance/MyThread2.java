package java_multi_thread_programming.c1.s10.p1_feature_of_Inheritance;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread.getPriority() = " + this.getPriority());
    }
}
