package java_multi_thread_programming.c1.s4;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin = " + myThread.isAlive());
        myThread.start();
        // 加不加sleep的区别
        Thread.sleep(1000);
        System.out.println("end = " + myThread.isAlive());
    }
}
