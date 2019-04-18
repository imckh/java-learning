package designpattern.creational_pattern.singleton_pattern.v3;

public class Singleton {
    private Singleton() {
    }

    /**
     * 我们在单例类中增加一个静态(static)内部类，在该内部类中创建单例对象，
     * 再将该单例对象通过getInstance()方法返回给外部使用
     *
     * 由于静态单例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton，
     * 第一次调用getInstance()时将加载内部类HolderClass，在该内部类中定义了一个static类型的变量instance，
     * 此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。
     * 由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响。
     */
    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String args[]) {
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }

}
