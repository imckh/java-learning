package java_multi_thread_programming.c1.s9;

public class MyThread extends Thread{

    @Override
    public void run() {
        long begintime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            //Thread.yield(); // 用时: 607ms
            count = count + (i + 1); // 用时: 8ms
        }
        long endtime = System.currentTimeMillis();
        System.out.println("用时: " + (endtime - begintime) + "ms");
    }
}
