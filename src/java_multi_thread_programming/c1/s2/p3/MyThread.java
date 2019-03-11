package java_multi_thread_programming.c1.s2.p3;

public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + currentThread().getName()
                    + " 计算, count = " + count);
        }
    }
}
