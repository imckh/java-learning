package java_multi_thread_programming.c1.s2.p3.threadsafe;

public class Alogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
