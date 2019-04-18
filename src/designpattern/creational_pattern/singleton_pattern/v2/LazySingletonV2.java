package designpattern.creational_pattern.singleton_pattern.v2;

/**
 * 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自
 * 行实例化，这种技术又称为延迟加载(Lazy Load)技术，即需要的时候再加载实例，为了避免
 * 多个线程同时调用getInstance()方法，我们可以使用关键字synchronized
 */
public class LazySingletonV2 {
    private static LazySingletonV2 instance = null;

    private LazySingletonV2() {
    }

    synchronized public static LazySingletonV2 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                // 只需对其中的代码“instance = new LazySingleton();”进行锁定即可
                instance = new LazySingletonV2();
                /*
                假如在某一瞬间线程A和线程B都在调用getInstance()方法，此时instance对象为null值，
                均能通过instance == null的判断。由于实现了synchronized加锁机制，
                线程A进入synchronized锁定的代码中执行实例创建代码，线程B处于排队等待状态，
                必须等待线程A执行完毕后才可以进入synchronized锁定代码。
                但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，导致产生多个单例对象
                 */
            }
        }
        return instance;
    }
}
