package java_multi_thread_programming.c1.s5;

public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(System.currentTimeMillis());
        myThread.run();
//        myThread.start();
        System.out.println(System.currentTimeMillis());
    }
}
