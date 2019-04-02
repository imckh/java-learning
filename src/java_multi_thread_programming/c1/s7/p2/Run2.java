package java_multi_thread_programming.c1.s7.p2;

public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt(); // 使main线程中断
        System.out.println(" 是否已经停止1 " + Thread.interrupted()); // true
        // 线程中断效果由该方法清除, 所以第二次返回false
        System.out.println(" 是否已经停止2 " + Thread.interrupted()); // false
        System.out.println("end");
    }
}
