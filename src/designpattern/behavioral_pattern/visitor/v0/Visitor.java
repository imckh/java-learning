package designpattern.behavioral_pattern.visitor.v0;

public abstract class Visitor {
    public abstract void visit(ConcreteElementA elementA);

    public abstract void visit(ConcreteElementB elementB);

//    public void visit(ConcreteElementC elementC) {
//        //元素ConcreteElementC操作代码
//    }
}
