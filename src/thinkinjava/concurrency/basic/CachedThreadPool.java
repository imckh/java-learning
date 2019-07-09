package thinkinjava.concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); // 将为每一个任务都创建一个线程

        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(new LiftOff());
        }
        cachedThreadPool.shutdown();
    }
}
