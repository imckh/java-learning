package java_multi_thread_programming.c2.s1.p5_dirtyRead;

public class ThreadA extends Thread {
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValur("B", "BB");
    }
}
