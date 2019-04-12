# java 学习笔记及代码

## [设计模式笔记](src/designpattern/README.MD)

[设计模式代码](src/designpattern)

### 创建者模式

1. [简单工厂模式](src/designpattern/creational_pattern/simple_factory_pattern/README.md)
    > 简单工厂模式(Simple Factory Pattern)：定义一个工厂类，它可以根据参数的不同返回不同类的
      实例，被创建的实例通常都具有共同的父类。因为在简单工厂模式中用于创建实例的方法是
      静态(static)方法，因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式

## [java多线程变成核心技术笔记](src/java_multi_thread_programming/README.md)

[java多线程变成核心技术代码](src/java_multi_thread_programming)

### [java多线程技能](src\java_multi_thread_programming\c1)

1. 概念
2. [使用多线程](src\java_multi_thread_programming\c1\s2)
    1. 继承`Thread`类
    2. 实现`Runnable`接口
    3. 实例变量与线程安全
    4. i++/i-- 非原子操作
3. [currentThread()](src\java_multi_thread_programming\c1\s3)
4. [isAlive()](src\java_multi_thread_programming\c1\s4)
5. [sleep()](src\java_multi_thread_programming\c1\s5)
6. [getId()](src\java_multi_thread_programming\c1\s6)
7. [停止线程](src\java_multi_thread_programming\c1\s7)
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
8. [暂停线程](src\java_multi_thread_programming\c1\s8)
    1. suspend, resume的使用
    2. 缺点--独占
    3. 缺点--不同步
9. [yield()](src\java_multi_thread_programming\c1\s9)
10. [线程的优先级](src\java_multi_thread_programming\c1\s10)
    1. 线程优先级具有继承性(指线程的继承, 不是面向对象的)
    2. 线程优先级具有规则性
    3. 线程优先级具有随机性
    4. 比比谁快
11. [守护线程](src\java_multi_thread_programming\c1\s11)
    不存在非守护线程, 守护线程自动销毁

## [java核心技术笔记](src/javacore)



## [关于java的其他一些代码](src/java_other)
