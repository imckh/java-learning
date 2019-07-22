package thinkinjava.concurrency.collaboration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}

class Car {
    private boolean waxOn = false;

    public synchronized void waxed() { // 打蜡结束
        waxOn = true; // Ready to buff
        notifyAll();
    }

    public synchronized void buffed() { // 抛光结束
        waxOn = false; // Ready for another coat of wax
        notifyAll();
    }

    public synchronized void waitForWaxing()
            throws InterruptedException { // 等待打蜡结束
        while (!waxOn)
            wait();
    }

    public synchronized void waitForBuffing()
            throws InterruptedException { // 等待抛光结束
        while (waxOn)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    public void run() { //给汽车打蜡
        try {
            while (!Thread.interrupted()) {
                System.out.print("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed(); // 打蜡结束
                car.waitForBuffing(); // 等待抛光
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() { // 给汽车抛光
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing(); // 等待打蜡结束
                System.out.print("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed(); // 抛光结束
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}