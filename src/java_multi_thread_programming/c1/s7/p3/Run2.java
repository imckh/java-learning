package java_multi_thread_programming.c1.s7.p3;

public class Run2 {
    public static void main(String[] args) {
        try {
            MyThread2 myThread = new MyThread2();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            /*
            i = 105775
            i = 105776
             已经是停止状态!
            end
             进入 MyThread2.run的catch
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
