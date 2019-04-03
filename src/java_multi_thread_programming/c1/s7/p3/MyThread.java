package java_multi_thread_programming.c1.s7.p3;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println(" 已经是停止状态!");
                break;
            }
            System.out.println("i = " + i);
        }
    }
}
