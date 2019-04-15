# java多线程变成核心技术

1. c -- chapter 章 1
2. s -- section 节 1.1
3. p -- part 部分 1.1.1

## [java多线程技能](c1)

1. 概念
2. [使用多线程](c1\s2)
    1. 继承`Thread`类
    2. 实现`Runnable`接口
    3. 实例变量与线程安全
    4. i++/i-- 非原子操作
3. [currentThread()](c1\s3)
4. [isAlive()](c1\s4)
5. [sleep()](c1\s5)
6. [getId()](c1\s6)
7. [停止线程](c1\s7)
    - 判断线程是否停止
        1. `static`this.interrupted() 执行后将状态清除
        2. this.isInterrupted() 不清除状态
    - 停止线程的方法
        1. 异常法
            1. `interrupt`后抛出`InterruptedException`异常
            2. sleep中中断会抛出`InterruptedException`异常
        2. 暴力停止-- `stop()` 
            1. 会给数据造成不一致的结果, 已被弃用
        3. 使用return
8. [暂停线程](c1\s8)
    1. suspend, resume的使用
    2. 缺点--独占
    3. 缺点--不同步
9. [yield()](c1\s9)
10. [线程的优先级](c1\s10)
    1. 线程优先级具有继承性(指线程的继承, 不是面向对象的)
    2. 线程优先级具有规则性
    3. 线程优先级具有随机性
    4. 比比谁快
11. [守护线程](c1\s11)
    不存在非守护线程, 守护线程自动销毁
    
## [对象及变量的并发访问](c2)

1. [synchronized同步方法](c2\s1)
    1. [方法内的变量为线程安全](c2\s1\p1)
    2. [实例变量非线程安全](c2\s1\p2)
        - 两个线程同时访问一个没有同步的方法, 同时操作对象中的实例变量, 可能出现非线程安全
        - 只需在`allI`加关键字`synchronized`即可
    3. 多个对象多个锁
        `synchronized`取得的是对象锁, 而不是把一段代码或者方法当做锁,
        如果多个线程访问多个对象, 则jvm会创建多个锁