package java_multi_thread_programming.c2.s1.p5_dirtyRead;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA t = new ThreadA(publicVar);
        t.start();
        Thread.sleep(200); // 打印结果受此值影响
        publicVar.getValue();
        /*
        setValue thread name = main username = B password = AA
        setValue thread name = Thread-0username = B password = BB
         */


    }
}
