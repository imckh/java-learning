package java_multi_thread_programming.c1.s2.p1;

public class MyThread extends Thread {
    private int n;

    public MyThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(n);

        /*try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
