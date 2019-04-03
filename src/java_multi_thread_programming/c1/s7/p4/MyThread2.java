package java_multi_thread_programming.c1.s7.p4;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i = " + i);
            }
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止, 再遇到了sleep! 进入catch!");
            e.printStackTrace();
        }
    }
}
