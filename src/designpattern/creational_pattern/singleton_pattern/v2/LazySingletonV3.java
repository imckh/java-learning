package designpattern.creational_pattern.singleton_pattern.v2;

/**
 * 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自
 * 行实例化，这种技术又称为延迟加载(Lazy Load)技术，即需要的时候再加载实例，为了避免
 * 多个线程同时调用getInstance()方法，我们可以使用关键字synchronized
 */
public class LazySingletonV3 {
    // 如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
    // 被volatile修饰的成员变量可以确保多个线程都能够正确处理，

    // 由于volatile关键字会屏蔽Java虚拟机所做的一些代码优化，可能会导致系统运行效率降低，
    // 因此即使使用双重检查锁定来实现单例模式也不是一种完美的实现方式。
    private volatile static LazySingletonV3 instance = null;

    private LazySingletonV3() {
    }

    synchronized public static LazySingletonV3 getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    // 在synchronized中再进行一次(instance == null)判断，
                    // 这种方式称为双重检查锁定(Double-CheckLocking)
                    instance = new LazySingletonV3(); //创建单例实例
                }
            }
        }

        return instance;
    }
}
