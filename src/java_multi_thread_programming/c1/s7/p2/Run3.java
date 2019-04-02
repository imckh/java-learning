package java_multi_thread_programming.c1.s7.p2;

public class Run3 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
            System.out.println(" 是否已经停止1 " + thread.isInterrupted()); // true
            System.out.println(" 是否已经停止2 " + thread.isInterrupted()); // true
            /**
             * thread.isInterrupted() 测试是否中断, 不清除状态
             * Thread.interrupted() 测试是否中断, 将状态标志清除为false
             */
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
