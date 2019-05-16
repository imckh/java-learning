# 外观模式-Facade Pattern

外观模式是一种使用频率非常高的结构型设计模式，它通过引入一个外观角色来简化客户端与子系统之间的交互，
为复杂的子系统调用提供一个统一的入口，降低子系统与客户端的耦合度，且客户端调用非常方便。

外观模式中，一个子系统的外部与其内部的通信通过一个统一的外观类进行，
外观类将客户类与子系统的内部复杂性分隔开，使得客户类只需要与外观角色打交道，
而不需要与子系统内部的很多对象打交道。

外观模式定义如下： 

> 为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。

外观模式又称为门面模式，它是一种对象结构型模式。外观模式是迪米特法则的一种具体实现，
通过引入一个新的外观角色可以降低原有系统的复杂度，同时降低客户类与子系统的耦合度。

![模式结构](https://design-patterns.readthedocs.io/zh_CN/latest/_images/Facade.jpg)

- Facade: 外观角色
- SubSystem:子系统角色

## v0 基本实现

```java
class SubSystemA {
    public void MethodA() {
		//业务实现代码
	}
}
class SubSystemB {
	public void MethodB() {
		//业务实现代码
	}
}
class SubSystemC {
	public void MethodC() {
	//业务实现代码
	}
}

class Facade {
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();
    public void Method() {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }
}

class Client {
    static void Main(string[] args) {
        Facade facade = new Facade();
        facade.Method();
    }
}
```

## [v1 使用抽象类](v1)

在标准的外观模式结构图中，如果需要增加、删除或更换与外观类交互的子系统类，
必须修改外观类或客户端的源代码，这将违背开闭原则，因此可以通过引入抽象外观类来对系统进行改进，
在一定程度上可以解决该问题。在引入抽象外观类之后，客户端可以针对抽象外观类进行编程，
对于新的业务需求，不需要修改原有外观类，而对应增加一个新的具体外观类，由新的具体外观类来关联新的子系统对象，
同时通过修改配置文件来达到不修改任何源代码并更换外观类的目的。

```java
abstract class SubSystem {
    public void MethodA() {
		//业务实现代码
	}
	public void MethodB() {
        //业务实现代码
    }
    public void MethodC() {
        //业务实现代码
    }

    public void action(SubSystem subSystem) {
        switch (subSystem.name()) {
            case A:
                MethodA();
                break;
            case B:
                MethodB();
                break;
            case C:
                MethodC();
                break;
            default:
                break;
        }
    }
    
    public abstract String name();
    
    static enum Action {
        A, B, C
    }
}

class SubSystemA extends SubSystem {
    @Override
    public void MethodA() {
		//业务实现代码
	}
	@Override
    public String name() {
        return Action.A;
    }
}
class SubSystemB extends SubSystem {
    @Override
	public void MethodB() {
		//业务实现代码
	}
	@Override
	public String name() {
		return Action.B;
	}
}
class SubSystemC extends SubSystem {
    @Override
	public void MethodC() {
        //业务实现代码
    }
    @Override
    public String name() {
        return Action.C;
    }
}

class Facade {
    private final List<SubSystem> list;
    public void Facade() {
        list = new ArrayList<>();
        list.add(new SubSystemA());
        list.add(new SubSystemB());
        list.add(new SubSystemC());
    }
    public void makeAction(List<SubSystem> list) {
        for (SubSystem subSystem : subSystems) {
            subSystem.action(subSystem);
        }
    }
}

```

## 总结

1.模式优点
    1. 它对客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起来更加容易。
    通过引入外观模式，客户端代码将变得很简单，与之关联的对象也很少。
    2. 它实现了子系统与客户端之间的松耦合关系，这使得子系统的变化不会影响到调用它的客户端，只需要调整外观类即可。
    3. 一个子系统的修改对其他子系统没有任何影响，而且子系统内部变化也不会影响到外观对象。
2. 模式缺点
    1. 不能很好地限制客户端直接使用子系统类，如果对客户端访问子系统类做太多的限制则减少了可变性和灵活性。
    2. 如果设计不当，增加新的子系统可能需要修改外观类的源代码，违背了开闭原则。

## 使用

- `java.lang.Class`
- `javax.faces.webapp.FacesServlet`