package java_multi_thread_programming.c1.s8.p3_suspend_resume_nosameValue;

public class Run {
    public static void main(String[] args) {
        try {
            final MyObject object = new MyObject();
            Thread t1 = new Thread(() -> object.setValue("a", "aa"));
            t1.setName("a");
            t1.start();
            Thread.sleep(500);
            Thread t2 = new Thread(object::printUP);
            t2.start();
            /*
            停止a线程
            username = a password = 11
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
