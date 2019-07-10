package thinkinjava.concurrency.atomic;

public class SyncObject {
    public static void main(String[] args) {
        final DualSync ds = new DualSync();
        new Thread() {
            @Override
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();

        /*
        * 在其他对象上同步
        * 两个方法使用的是同的锁，因此两个同步是相互独立的
        * */
    }
}
class DualSync {
    private final Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) { // 如果将syncObject改为this，则两个不能同时运行，因为使用了相同的锁
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
