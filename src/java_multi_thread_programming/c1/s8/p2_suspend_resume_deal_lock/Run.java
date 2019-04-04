package java_multi_thread_programming.c1.s8.p2_suspend_resume_deal_lock;

public class Run {
    public static void main(String[] args) {
        try {
            // suspend resume 容易造成公共同步对象的独占
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread(object::printString);
//        上下语句相同
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                object.printString();
//            }
//        };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);

            Thread thread2 = new Thread(() -> {
                System.out.println("thread2 启动了, 但进不了printString方法");
                System.out.println("因为printString方法呗a线程锁定并永远suspend暂停了");
                object.printString();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
