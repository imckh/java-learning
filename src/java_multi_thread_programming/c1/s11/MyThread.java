package java_multi_thread_programming.c1.s11;

public class MyThread extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                count++;
                System.out.println("count = " + count);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
