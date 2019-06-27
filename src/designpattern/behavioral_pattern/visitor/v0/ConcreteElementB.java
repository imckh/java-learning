package designpattern.behavioral_pattern.visitor.v0;

public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        //业务方法
    }
}
