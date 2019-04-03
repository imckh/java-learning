package java_multi_thread_programming.c1.s7.p4;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在sleep中被停止 进入catch! " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
