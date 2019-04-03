package java_multi_thread_programming.c1.s7.p3;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            /*
            i = 115927
            i = 115928
            i = 115929
            i = 115930
            end
             已经是停止状态!
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
