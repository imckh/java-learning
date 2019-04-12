package java_multi_thread_programming.c1.s10.p3_random;

import java.util.Random;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("***** Thread 1 time = " + (endTime - beginTime));
    }
}
