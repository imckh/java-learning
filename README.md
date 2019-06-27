# java 学习笔记及代码

## [设计模式笔记](src/designpattern/README.MD)

[设计模式代码](src/designpattern)

### 创建者模式(Creational Pattern)

1. [简单工厂模式(Simple Factory Pattern)](src/designpattern/creational_pattern/simple_factory_pattern/README.md)
    > 简单工厂模式(Simple Factory Pattern)：定义一个工厂类，它可以根据参数的不同返回不同类的
      实例，被创建的实例通常都具有共同的父类。因为在简单工厂模式中用于创建实例的方法是
      静态(static)方法，因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式
2. [工厂方法模式(Factory Method Pattern)](src/designpattern/creational_pattern/factory_method_pattern/README.md)
    > 定义一个用于创建对象的接口，让子类决定将哪一个
      类实例化。工厂方法模式让一个类的实例化延迟到其子类。工厂方法模式又简称为工厂模式
      (Factory Pattern)，又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式
      (Polymorphic Factory Pattern)。工厂方法模式是一种类创建型模式。
3. [抽象工厂模式(Abstract Factory Pattern)](src/designpattern/creational_pattern/abstract_factory_pattern/README.md)
    > 抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而
      无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。<br>
      在抽象工厂模式中，每一个具体工厂都提供了多个工厂方法用于产生多种不同类型的产品，
      这些产品构成了一个产品族
4. [单例模式(Singleton Pattern)](src/designpattern/creational_pattern/singleton_pattern/README.md)
    > 单例模式(Singleton Pattern)：确保某一个类只有一个实例，
     而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。
     单例模式是一种对象创建型模式。
5. [原型模式(Prototype Pattern)](src/designpattern/creational_pattern/prototype_pattern/README.md)
    > 原型模式(Prototype Pattern)：使用原型实例指定创建对象的种类，
     并且通过拷贝这些原型创建新的对象。原型模式是一种对象创建型模式。
6. [建造者模式(Builder Pattern)](src/designpattern/creational_pattern/builder_pattern/README.md)
    > 建造者模式(Builder Pattern)：将一个复杂对象的构建与它的表示分离，
      使得同样的构建过程可以创建不同的表示。建造者模式是一种对象创建型模式。

### 结构型模式(Structural Pattern)
1. [适配器模式(Adapter Pattern)](src/designpattern/structural_pattern/adapter/README.md)
    > 适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
    适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
2. [桥接模式(Bridge Pattern)](src/designpattern/structural_pattern/bridge/README.md)
    > 将抽象部分与它的实现部分分离，使它们都可以独立地变化。它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interface)模式。
3. [组合模式(Composite Pattern)](src/designpattern/structural_pattern/composite/README.md)
    > 组合多个对象形成树形结构以表示具有“整体—部分”关系的层次结构。
    组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致性，
    组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式。
4. [装饰模式(Decorator Pattern)](src/designpattern/structural_pattern/decorator/README.md)
    > 动态地给一个对象增加一些额外的职责，就增加对象功能来说，
      装饰模式比生成子类实现更为灵活。装饰模式是一种对象结构型模式。
5. [外观模式(Facade Pattern)](src/designpattern/structural_pattern/facade/README.md)
    > 外观模式：为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
6. [享元模式(Flyweight Pattern)](src/designpattern/structural_pattern/flyweight/README.md)
    > 享元模式：运用共享技术有效地支持大量细粒度对象的复用。
7. [代理模式(Proxy Pattern)](src/designpattern/structural_pattern/proxy/README.md)
    > 代理模式：给某一个对象提供一个代理或占位符，并由代理对象来控制对原对象的访问。

### 行为型模式(Behavioral Pattern)
1. [职责链模式(Chain of Responsibility Pattern)](src/designpattern/behavioral_pattern/chain/README.md)
    > 避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
2. [命令模式(Command Pattern)](src/designpattern/behavioral_pattern/command/README.md)
    > 将一个请求封装为一个对象，从而让我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销的操作。
3. [解释器模式(Interpreter Pattern)](src/designpattern/behavioral_pattern/interpreter/README.md)
    > 解释器模式(Interpreter Pattern)：定义一个语言的文法，并且建立一个解释器来解释该语言中的句子，这里的“语言”是指使用规定格式和语法的代码。
4. [迭代器模式(Iterator Pattern)](src/designpattern/behavioral_pattern/iterator/README.md)
    > 提供一种方法来访问聚合对象，而不用暴露这个对象的内部表示，其别名为游标(Cursor)。
5. [中介者模式(Mediator Pattern)](src/designpattern/behavioral_pattern/mediator/README.md)
    > 用一个中介对象（中介者）来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，
    而且可以独立地改变它们之间的交互。
6. [备忘录模式(Memento Pattern)](src/designpattern/behavioral_pattern/memento/README.md)
    > 在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
7. [观察者模式(Observer Pattern)](src/designpattern/behavioral_pattern/observer/README.md)
    > 定义对象之间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新。
8. [状态模式(State Pattern)](src/designpattern/behavioral_pattern/state/README.md)
    > 允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。
9. [策略模式(Strategy Pattern)](src/designpattern/behavioral_pattern/strategy/README.md)
    > 定义一系列算法类，将每一个算法封装起来，并让它们可以相互替换，策略模式让算法独立于使用它的客户而变化，也称为政策模式(Policy)。
10. [模板方法模式(Template Method Pattern)](src/designpattern/behavioral_pattern/template/README.md)
    > 定义一个操作中算法的框架，而将一些步骤延迟到子类中。模板方法模式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
11. [访问者模式(Visitor Pattern)](src/designpattern/behavioral_pattern/visitor/README.md)
    > 提供一个作用于某对象结构中的各元素的操作表示，它使我们可以在不改变各元素的类的前提下定义作用于这些元素的新操作。

## [java多线程变成核心技术笔记](src/java_multi_thread_programming/README.md)

[java多线程变成核心技术代码](src/java_multi_thread_programming)

### [java多线程技能](src/java_multi_thread_programming/c1)

1. 概念
2. [使用多线程](src/java_multi_thread_programming/c1/s2)
    1. 继承`Thread`类
    2. 实现`Runnable`接口
    3. 实例变量与线程安全
    4. i++/i-- 非原子操作
3. [currentThread()](src/java_multi_thread_programming/c1/s3)
4. [isAlive()](src/java_multi_thread_programming/c1/s4)
5. [sleep()](src/java_multi_thread_programming/c1/s5)
6. [getId()](src/java_multi_thread_programming/c1/s6)
7. [停止线程](src/java_multi_thread_programming/c1/s7)
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
8. [暂停线程](src/java_multi_thread_programming/c1/s8)
    1. suspend, resume的使用
    2. 缺点--独占
    3. 缺点--不同步
9. [yield()](src/java_multi_thread_programming/c1/s9)
10. [线程的优先级](src/java_multi_thread_programming/c1/s10)
    1. 线程优先级具有继承性(指线程的继承, 不是面向对象的)
    2. 线程优先级具有规则性
    3. 线程优先级具有随机性
    4. 比比谁快
11. [守护线程](src/java_multi_thread_programming/c1/s11)
    不存在非守护线程, 守护线程自动销毁

## [java核心技术笔记](src/javacore)



## [关于java的其他一些代码](src/java_other)
