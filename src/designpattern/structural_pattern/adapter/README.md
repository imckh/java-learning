# 适配器模式-Adapter Pattern

与电源适配器相似，在适配器模式中引入了一个被称为适配器(Adapter)的包装类，
而它所包装的对象称为适配者(Adaptee)，即被适配的类。
适配器的实现就是把客户类的请求转化为对适配者的相应接口的调用。

适配器模式定义如下：

适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，
使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。

角色：
- Target（目标抽象类）：目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以是具体类。
- Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，
适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系。
- Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，
适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码。

```java
class Adapter extends Target {
    private Adaptee adaptee; //维持一个对适配者对象的引用
    public Adapter(Adaptee adaptee) {
        this.adaptee=adaptee;
    }
    public void request() {
        adaptee.specificRequest(); //转发调用
    }
}
```

## [v0](v0) 使用适配器模式来重用算法库中的算法

- ScoreOperation接口充当抽象目标
- QuickSort和BinarySearch类充当适配者
- OperationAdapter充当适配器

## 类适配器

除了对象适配器模式之外，适配器模式还有一种形式，那就是类适配器模式，
类适配器模式和对象适配器模式最大的区别在于适配器和适配者之间的关系不同，
对象适配器模式中适配器和适配者之间是关联关系，而类适配器模式中适配器和适配者是继承关系

根据类适配器模式结构图，适配器类实现了抽象目标类接口Target，并继承了适配者类，
在适配器类的request()方法中调用所继承的适配者类的specificRequest()方法，实现了适配。

```java
class Adapter extends Adaptee implements Target {
    public void request() {
        specificRequest();
    }
}
```

## 双向适配器

如果在适配器中同时包含对目标类和适配者类的引用，适配者可以通过它调用目标类中的方法，
目标类也可以通过它调用适配者类中的方法，那么该适配器就是一个双向适配器

```java
class Adapter implements Target,Adaptee {
    //同时维持对抽象目标类和适配者的引用
    private Target target;
    private Adaptee adaptee;
    public Adapter(Target target) {
        this.target = target;
    }
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void request() {
        adaptee.specificRequest();
    }
    public void specificRequest() {
        target.request();
    }
}
```

## 缺省适配器

> 缺省适配器模式(Default Adapter Pattern)：当不需要实现一个接口所提供的所有方法时，可先设计一个抽象类实现该接口，
并为接口中每个方法提供一个默认实现（空方法），那么该抽象类的子类可以选择性地覆盖父类的某些方法来实现需求，
它适用于不想使用一个接口中的所有方法的情况，又称为单接口适配器模式。

在JDK类库的事件处理包java.awt.event中广泛使用了缺省适配器模式，如WindowAdapter、KeyAdapter、MouseAdapter等。

## 例子

- `java.util.Arrays#asList()`
- `java.util.Collections#list()`
- `java.util.Collections#enumeration()`
- `javax.xml.bind.annotation.adapters.XMLAdapter`

## 总结

1. 主要优点
    1. 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构
    2. 增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，
    而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用
    3. 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，
    也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”
2. 主要缺点
    1. 对于Java、C#等不支持多重类继承的语言，一次最多只能适配一个适配者类，不能同时适配多个适配者
    2. 适配者类不能为最终类，如在Java中不能为final类，C#中不能为sealed类
    3. 在Java、C#等语言中，类适配器模式中的目标抽象类只能为接口，不能为类，其使用有一定的局限性