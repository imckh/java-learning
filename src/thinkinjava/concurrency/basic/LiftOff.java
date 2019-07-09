package thinkinjava.concurrency.basic;

public class LiftOff implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10; // Default

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
            // 我已经执行完生命周期中最重要的部分，现在是切换给其他任务执行一段时间的大好时机
        }
    }

    public static void main(String[] args) {
        /*LiftOff liftOff = new LiftOff();
        Thread a = new Thread(liftOff);
        a.start();
*/
        System.out.println("waiting for liftoff");

        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}
