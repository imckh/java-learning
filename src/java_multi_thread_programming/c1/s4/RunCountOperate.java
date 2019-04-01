package java_multi_thread_programming.c1.s4;

public class RunCountOperate {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive=" + t1.isAlive());
        /*
        CountOperate---begin
        Thread.currentThread().getName() = main // 在还没有启动CountOperate线程的时候，调用这段代码的是main线程
        Thread.currentThread().isAlive() = true
        this.getName() = Thread-0
        this.isAlive() = false
        CountOperate---end
        main begin t1 isAlive=false
        main end t1 isAlive=true
        run---begin
        Thread.currentThread().getName() = A
        Thread.currentThread().isAlive() = true
        this.getName() = Thread-0
        this.isAlive() = false
        Thread.currentThread() == this : false
        run---end
        将线程对象以构造参数的方式传递给Thread对象进行start()启动线程,
        我们直接启动的线程实际是newThread, 而作为构造参数的myThread,
        赋给Thread类中的属性target, 之后在Thread的run方法中调用target.run()
        此时Thread.currentThread()是Thread的引用newThread,
        而this依旧是MyThread的引用, 所以是不一样的, 打印的内容也不一样
        https://blog.csdn.net/championhengyi/article/details/76664491
         */
    }
}
