package designpattern.creational_pattern.singleton_pattern.v2;

/**
 * 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自
 * 行实例化，这种技术又称为延迟加载(Lazy Load)技术，即需要的时候再加载实例，为了避免
 * 多个线程同时调用getInstance()方法，我们可以使用关键字synchronized
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    synchronized public static LazySingleton getInstance() {
        // 每次调用getInstance()时都需要进行线程锁定判断，在多线程高并发访问环境中，将会导致系统性能大大降低。
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
