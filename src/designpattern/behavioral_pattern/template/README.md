# 模板方法模式-Template Method Pattern

模板方法模式：

> 定义一个操作中算法的框架，而将一些步骤延迟到子类中。模板方法模
式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

模板方法模式是一种基于继承的代码复用技术，它是一种类行为型模式。

模板方法模式是结构最简单的行为型设计模式，在其结构中只存在父类与子类之间的继承关系。
通过使用模板方法模式，可以将一些复杂流程的实现步骤封装在一系列基本方法中，
在抽象父类中提供一个称之为模板方法的方法来定义这些基本方法的执行次序，而通过其子类来覆盖某些步骤，
从而使得相同的算法框架可以有不同的执行结果。模板方法模式提供了一个模板方法来定义算法框架，而某些具体步骤的实现可以在其子类中完成。

## v0 简单实现

```java
abstract class AbstractClass {
    public void method() {
        operation1();
        operation2();
        if (isDoSomething()) {
            operation3();
        }
    }
    public abstract void operation1() {}
    public void operation2() {}
    public void operation3() {}
    public boolean isDoSomething() {
        return false;
    }
}
class ConcreteClass extends AbstractClass {
    @Override
    public boolean isDoSomething() {
        return true;
    }
    @Override
    public void operation1() {
        // operation 1
    }
    @Override
    public void operation3() {
        // operation 3
    }
}
class Client {
    public static void main(String[] args){
        AbstractClass ac = new ConcreteClass();
        ac.method();
    }
}
```

1. AbstractClass（抽象类）：在抽象类中定义了一系列基本操作(PrimitiveOperations)，这些基本操作可以是具体的，
也可以是抽象的，每一个基本操作对应算法的一个步骤，在其子类中可以重定义或实现这些步骤。
同时，在抽象类中实现了一个模板方法(Template Method)，用于定义一个算法的框架，模板方法不仅可以调用在抽象类中实现的基本方法，
也可以调用在抽象类的子类中实现的基本方法，还可以调用其他对象中的方法。
2. ConcreteClass（具体子类）：它是抽象类的子类，用于实现在父类中声明的抽象基本操作以完成子类特定算法的步骤，
也可以覆盖在父类中已经实现的具体基本操作。

一个模板方法是定义在抽象类中的、把基本操作方法组合在一起形成一个总算法或一个总行为的方法。

基本方法是实现算法各个步骤的方法，是模板方法的组成部分。基本方法又可以分为三种：抽象方法(Abstract Method)、具体方法(Concrete Method)和钩子方法(Hook Method)。

1. 抽象方法：一个抽象方法由抽象类声明、由其具体子类实现。
2. 具体方法：一个具体方法由一个抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承。
3. 钩子方法：一个钩子方法由一个抽象类或具体类声明并实现，而其子类可能会加以扩展。
    > 比如上述代码中的`ConcreteClass.isDoSomething`方法

## 总结

模板方法的实现很简单, 这里不做过多的赘述, 日常使用其实经常用的模板方法. 

常用于在父类中提供了一个定义算法框架的模板方法，还提供了一系列抽象方法、具体方法和钩子方法，其中钩子方法的引入使得子类可以控制父类的行为。
确保通过父类来控制处理流程的逻辑顺序（如框架的初始化，测试流程的设置等）。

1. 模式优点
    1. 在父类中形式化地定义一个算法，而由它的子类来实现细节的处理，在子类实现详细的处理算法时并不会改变算法中步骤的执行次序。
    2. 模板方法模式是一种代码复用技术，它在类库设计中尤为重要，它提取了类库中的公共行为，将公共行为放在父类中，
    而通过其子类来实现不同的行为，它鼓励我们恰当使用继承来实现代码复用。
    3. 可实现一种反向控制结构，通过子类覆盖父类的钩子方法来决定某一特定步骤是否需要执行。
    4. 在模板方法模式中可以通过子类来覆盖父类的基本方法，不同的子类可以提供基本方法的不同实现，更换和增加新的子类很方便，
符合单一职责原则和开闭原则。
2. 模式缺点
    需要为每一个基本方法的不同实现提供一个子类，如果父类中可变的基本方法太多，将会导致类的个数增加，
    系统更加庞大，设计也更加抽象，此时，可结合桥接模式来进行设计。

## 使用

- `java.io.InputStream, java.io.OutputStream, java.io.Reader和java.io.Writer的所有非抽象方法`
- `java.util.AbstractList, java.util.AbstractSet和java.util.AbstractMap的所有非抽象方法`
- `javax.servlet.http.HttpServlet#doXXX()`