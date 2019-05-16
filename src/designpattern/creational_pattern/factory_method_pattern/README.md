# 工厂方法模式

> 在简单工厂模式中只提供一个工厂类，该工厂类处于对产品类进行实例化的中心位置，它需
要知道每一个产品对象的创建细节，并决定何时实例化哪一个产品类。简单工厂模式最大的
缺点是当有新产品要加入到系统中时，必须修改工厂类，需要在其中加入必要的业务逻辑，
这违背了“开闭原则”。此外，在简单工厂模式中，所有的产品都由同一个工厂创建，工厂类职
责较重，业务逻辑较为复杂，具体产品与工厂类之间的耦合度高，严重影响了系统的灵活性
和扩展性，而工厂方法模式则可以很好地解决这一问题。

> 在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同
的产品提供不同的工厂，系统提供一个与产品等级结构对应的工厂等级结构。

## v1

LoggerFactory充当创建日志记录器的工厂，提供了工厂方法createLogger()用于创建
日志记录器，Logger是抽象日志记录器接口，其子类为具体日志记录器。其中，工厂类
LoggerFactory代码片段如下所示：
```java
//日志记录器工厂
class LoggerFactory {
    //静态工厂方法
    public static Logger createLogger(String args) {
        if(args.equalsIgnoreCase("db")) {
            //连接数据库，代码省略
            //创建数据库日志记录器对象
            Logger logger = new DatabaseLogger();
            //初始化数据库日志记录器，代码省略
            return logger;
        } else if(args.equalsIgnoreCase("file")) {
            //创建日志文件
            //创建文件日志记录器对象
            Logger logger = new FileLogger();
            //初始化文件日志记录器，代码省略
            return logger;
        } else {
            return null;
        }
    }
}
```

## v2

- Product（抽象产品）：它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。
- ConcreteProduct（具体产品）：它实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，具体工厂和具体产品之间一一对应。
- Factory（抽象工厂）：在抽象工厂类中，声明了工厂方法(Factory Method)，用于返回一个产品。抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
- ConcreteFactory（具体工厂）：它是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户端调用，返回一个具体产品类的实例。

## [v3](v3)
`Logger`接口充当抽象产品，其子类`FileLogger`和`DatabaseLogger`充当具体产品，
`LoggerFactory`接口充当抽象工厂，其子类`FileLoggerFactory`和`DatabaseLoggerFactory`充当具体工厂。

*使用配置文件+反射创建工厂子类*

## [v4](v4)

1. 重载的工厂方法
2. 工厂方法的隐藏
    > 对客户端隐藏工厂方法，此时，在工厂类中
      将直接调用产品类的业务方法，客户端无须调用工厂方法创建产品，直接通过工厂即可使用
      所创建的对象中的业务方法。

## 使用

- `java.lang.Object#toString() (在其子类中可以覆盖该方法)`
- `java.lang.Class#newInstance()`
- `java.lang.Integer#valueOf(String) (Boolean, Byte, Character,Short, Long, Float 和 Double与之类似)`
- `java.lang.Class#forName()`
- `java.lang.reflect.Array#newInstance()`
- `java.lang.reflect.Constructor#newInstance()`