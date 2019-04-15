package java_multi_thread_programming.c2.s1.p3_twoObjectTwoLock;

public class ThreadA extends Thread {
    private HasSelfPrivateNum num;

    public ThreadA(HasSelfPrivateNum num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("a");
    }
}
