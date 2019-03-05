package java_multi_thread_programming.c1.s2.p1;

public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread m1 = new MyThread(1);
        MyThread m2 = new MyThread(2);
        MyThread m3 = new MyThread(3);
        MyThread m4 = new MyThread(4);
        MyThread m5 = new MyThread(5);
        MyThread m6 = new MyThread(6);
        MyThread m7 = new MyThread(7);
        MyThread m8 = new MyThread(8);
        MyThread m9 = new MyThread(9);
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
        m6.start();
        m7.start();
        m8.start();
        m9.start();
    }
}
