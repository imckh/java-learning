# java多线程变成核心技术

1. c -- chapter 章 1
2. s -- section 节 1.1
3. p -- part 部分 1.1.1

## [java多线程技能](c1)

1. 概念
2. [使用多线程](c1/s2)
    1. 继承`Thread`类
    2. 实现`Runnable`接口
    3. 实例变量与线程安全
    4. i++/i-- 非原子操作
3. [currentThread()](c1/s3)
4. [isAlive()](c1/s4)
5. [sleep()](c1/s5)
6. [getId()](c1/s6)
7. [停止线程](c1/s7)
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
8. [暂停线程](c1/s8)
    1. suspend, resume的使用
    2. 缺点--独占
    3. 缺点--不同步
9. [yield()](c1/s9)
10. [线程的优先级](c1/s10)
    1. 线程优先级具有继承性(指线程的继承, 不是面向对象的)
    2. 线程优先级具有规则性
    3. 线程优先级具有随机性
    4. 比比谁快
11. [守护线程](c1/s11)
    不存在非守护线程, 守护线程自动销毁
    
## [对象及变量的并发访问](c2)

1. [synchronized同步方法](c2/s1)
    1. [方法内的变量为线程安全](c2/s1/p1)
    2. [实例变量非线程安全](c2/s1/p2)
        - 两个线程同时访问一个没有同步的方法, 同时操作对象中的实例变量, 可能出现非线程安全
        - 只需在`allI`加关键字`synchronized`即可
    3. [多个对象多个锁](c2/s1/p3_twoObjectTwoLock)
        `synchronized`取得的是对象锁, 而不是把一段代码或者方法当做锁,
        如果多个线程访问多个对象, 则jvm会创建多个锁
    4. [synchronized方法与锁对象](c2/s1/p4_sychronizedMethodLockObject)
        1. 线程锁的是对象
        2. 只有共享资源的读写访问才需要同步, 否则根本没必要
    5. 脏读: 在读取实例变量的时候, 该值已经被其他线程修改过了
    6. synchronized锁重入
        在使用synchronized时, 当一个线程得到一个对象的锁后, 再次请求对象锁时是可以再次得到的, 
        这也证明在一个synchronized内部调用本类其他synchronized块时, 是可以得到锁的.
        (子类可以通过可重入锁调用父类同步方法)
    7. 出现异常, 锁自动释放
    8. 同步不可继承
2. synchronized 同步语句块
    1. synchronized 方法的弊端: 方法内部可能会有一些代码并不需要同步
    2. 当两个并发线程访问同一个对象 object 中的 synchronized(this) 方法块时,
    一段时间内只能有一个线程被执行, 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块
    3. 使用同步代码块来解决同步方法的弊端
        当一个线程访问object的一个 synchronized 同步代码块时, 另一个线程仍然可以访问该对象中的非 
        synchronized(this) 同步代码块
    4. 一半异步, 一半同步
        在 synchronized 代码块中的就是同步执行, 不在其中的异步执行