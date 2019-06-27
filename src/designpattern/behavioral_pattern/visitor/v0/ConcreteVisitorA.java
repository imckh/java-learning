package designpattern.behavioral_pattern.visitor.v0;

public class ConcreteVisitorA extends Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        //元素ConcreteElementA操作代码
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        //元素ConcreteElementB操作代码
    }
}
