package java_multi_thread_programming.c1.s10.p1_feature_of_Inheritance;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1.getPriority() = " + this.getPriority());
        MyThread2 t2 = new MyThread2();
        t2.start();
    }
}
