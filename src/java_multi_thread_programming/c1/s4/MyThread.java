package java_multi_thread_programming.c1.s4;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("this.isAlive() = " + this.isAlive());
    }
}
