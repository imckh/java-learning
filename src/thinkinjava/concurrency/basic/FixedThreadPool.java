package thinkinjava.concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(5);
        // 使用有限的线程集来执行所提交的任务

        for (int i = 0; i < 5; i++) {
            exe.execute(new LiftOff());
        }
        exe.shutdown();
    }
}
