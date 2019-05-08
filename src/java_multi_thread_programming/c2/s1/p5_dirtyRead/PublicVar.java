package java_multi_thread_programming.c2.s1.p5_dirtyRead;

public class PublicVar {
    public String username = "A";
    public String password = "AA";

    public synchronized void setValur(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            System.out.print("setValue thread name = " + Thread.currentThread().getName());
            System.out.print("username = " + username);
            System.out.println(" password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 出现脏读是应为getvalue方法并不同步, 所以可以在任意时候调用
    // 加上synchronized关键字后不再出现脏读
    public synchronized void getValue() {
        System.out.print("setValue thread name = " + Thread.currentThread().getName());
        System.out.print(" username = " + username);
        System.out.println(" password = " + password);
    }
}
