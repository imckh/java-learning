package java_multi_thread_programming.c2.s1.p1;

public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum n = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(n);
        a.start();
        ThreadB b = new ThreadB(n);
        b.start();
    }
}
