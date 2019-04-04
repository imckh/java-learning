package java_multi_thread_programming.c1.s8.p2_suspend_resume_LockStop;

public class MyThread extends Thread{
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println("i = " + i);
        }
    }
}
