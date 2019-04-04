package java_multi_thread_programming.c1.s8.p3_suspend_resume_nosameValue;

public class MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String u, String p) {
        this.username = u;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }

    public void printUP() {
        System.out.print("username = " + username);
        System.out.println(" password = " + password);
    }
}
