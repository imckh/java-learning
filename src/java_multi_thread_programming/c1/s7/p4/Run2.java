package java_multi_thread_programming.c1.s7.p4;

public class Run2 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.start();
        myThread.interrupt();
        System.out.println("end");
    }
}
