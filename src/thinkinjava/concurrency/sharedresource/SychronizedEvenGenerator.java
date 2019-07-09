package thinkinjava.concurrency.sharedresource;

public class SychronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // 更快的发现失败
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SychronizedEvenGenerator());
    }
}
