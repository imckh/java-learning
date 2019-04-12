package java_multi_thread_programming.c1.s10.p4;

import java.util.Random;

public class MyThread1 extends Thread{
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
