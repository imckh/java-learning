package java_multi_thread_programming.c1.s7.p7;

public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread thread = new MyThread(object);
            thread.start();
            Thread.sleep(500);
            thread.stop(); // 使用stop释放锁会给数据造成不一致的结果, 不建议使用
            System.out.printf("object.getUsername() = %s, object.getPassword() = %s",
                    object.getUsername(), object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
