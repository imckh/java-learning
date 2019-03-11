package java_multi_thread_programming.c1.s2.p3.threadsafe;

public class Blogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}