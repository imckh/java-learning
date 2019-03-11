package java_multi_thread_programming.c1.s2.p3.threadsafe;

public class Run {
    public static void main(String[] args) {
        Alogin a = new Alogin();
        a.start();
        Blogin b = new Blogin();
        b.start();
    }
}
