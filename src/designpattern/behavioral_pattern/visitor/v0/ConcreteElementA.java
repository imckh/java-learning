package designpattern.behavioral_pattern.visitor.v0;

public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        //业务方法
    }
}
