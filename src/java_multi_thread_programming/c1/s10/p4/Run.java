package java_multi_thread_programming.c1.s10.p4;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread1 t1 = new MyThread1();
            t1.setPriority(Thread.NORM_PRIORITY - 3);
            t1.start();

            MyThread2 t2 = new MyThread2();
            t2.setPriority(Thread.NORM_PRIORITY + 3);
            t2.start();

            Thread.sleep(1000);

            t1.stop();
            t2.stop();

            System.out.println("t1 Count = " + t1.getCount());
            System.out.println("t2 Count = " + t2.getCount());

            /*
            t1 Count = 155929928
            t2 Count = 402372001
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
