package java_multi_thread_programming.c1.s2.p3;

public class Run {
    public static void main(String[] args) {
        /*
        // 线程数据不共享
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();*/

        /*// 共享线程数据
        MyThreadShared mts = new MyThreadShared();
        Thread A = new Thread(mts, "A");
        Thread B = new Thread(mts, "B");
        Thread C = new Thread(mts, "C");
        Thread D = new Thread(mts, "D");
        Thread E = new Thread(mts, "E");
        A.start();
        B.start();
        C.start();
        D.start();
        E.start();*/

        // 共享线程数据 , 加锁
        MyThreadSharedSychronized mts = new MyThreadSharedSychronized();
        Thread A = new Thread(mts, "A");
        Thread B = new Thread(mts, "B");
        Thread C = new Thread(mts, "C");
        Thread D = new Thread(mts, "D");
        Thread E = new Thread(mts, "E");
        A.start();
        B.start();
        C.start();
        D.start();
        E.start();
    }
}
