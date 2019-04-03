package java_multi_thread_programming.c1.s7.p3;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println(" 已经是停止状态!");
                    throw new InterruptedException();
                }
                System.out.println("i = " + i);
            }
            System.out.println("我被输出, 如果此代码是for还会继续运行, 线程并未停止");
        } catch (InterruptedException e) {
            System.out.println(" 进入 MyThread2.run的catch");
            System.out.println();
        }
    }
}
