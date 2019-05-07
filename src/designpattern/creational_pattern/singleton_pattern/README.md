# 确保对象的唯一性 单例模式-Singleton Pattern

单例模式(Singleton Pattern)：确保某一个类只有一个实
例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方
法。单例模式是一种对象创建型模式。

单例模式有三个要点：一是某个类只能有一个实例；二是它必须自行创建这个实例；三是它
必须自行向整个系统提供这个实例。

## [v0](v0)
Singleton（单例）：在单例类的内部实现只生成一个实例，同时它提供一个静态的
getInstance()工厂方法，让客户可以访问它的唯一实例；为了防止在外部对其实例化，将其构
造函数设计为私有；在单例类内部定义了一个Singleton类型的静态对象，作为外部共享的唯一
实例。

## [v1](v1)
将负载均衡器LoadBalancer设计为单例类，其中包含一个存储服务器信息的集合serverList，
每次在serverList中随机选择一台服务器来响应客户端的请求

虽然创建了四个LoadBalancer对象，但是它们实际上是同一个对象，因此，通过使用单例模式
可以确保LoadBalancer对象的唯一性。

## [v2](v2) 饿汉式单例与懒汉式单例

当第一次调用getLoadBalancer()方法创建并启动负载均衡器时，instance对象为null值，
因此系统将执行代码instance= new LoadBalancer()，在此过程中，
由于要对LoadBalancer进行大量初始化工作，需要一段时间来创
建LoadBalancer对象。而在此时，如果再一次调用getLoadBalancer()方法（通常发生在多线程环境中），
由于instance尚未创建成功，仍为null值，判断条件(instance== null)为真值，
因此代码instance= new LoadBalancer()将再次执行，导致最终创建了多个instance对象，
这违背了单例模式的初衷，也导致系统运行发生错误。

## [v3](v3) Initialization Demand Holder (IoDH)

饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控制烦琐，而且性能受影响。

我们在单例类中增加一个静态(static)内部类，在该内部类中创建单例对象，
再将该单例对象通过getInstance()方法返回给外部使用

由于静态单例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton，
第一次调用getInstance()时将加载内部类HolderClass，在该内部类中定义了一个static类型的变量instance，
此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。
由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响。

通过使用IoDH，我们既可以实现延迟加载，又可以保证线程安全，不影响系统性能，不失为一种最好的Java语言单例模式实现方式

## 总结

1. 主要优点
    1. 单例模式提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，所以它可以严格控制客户怎样以及何时访问它。
    2. 由于在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销毁的对象单例模式无疑可以提高系统的性能。
    3. 允许可变数目的实例。基于单例模式我们可以进行扩展，使用与单例控制相似的方法来获得指定个数的对象实例，
    既节省系统资源，又解决了单例单例对象共享过多有损性能的问题。
2. 主要缺点
    1. 由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。
    2. 单例类的职责过重，在一定程度上违背了“单一职责原则”。因为单例类既充当了工厂角色，提供了工厂方法，
    同时又充当了产品角色，包含一些业务方法，将产品的创建和产品的本身的功能融合到一起。
    3. 现在很多面向对象语言(如Java、C#)的运行环境都提供了自动垃圾回收的技术，因此，
    如果实例化的共享对象长时间不被利用，系统会认为它是垃圾，会自动销毁并回收资源，
    下次利用时又将重新实例化，这将导致共享的单例对象状态的丢失。