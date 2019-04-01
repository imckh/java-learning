package java_multi_thread_programming.c1.s3;

public class Run2 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // run方法: Thread-0
        thread.run(); // run方法: main
    }
}
