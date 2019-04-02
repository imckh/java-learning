package java_multi_thread_programming.c1.s7.p2;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println(" 是否已经停止1 " + myThread.interrupted()); // true
            System.out.println(" 是否已经停止2 " + myThread.interrupted()); // true
            // Thread.interrupted() 测试当前线程是否中断, 当前线程是main
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
