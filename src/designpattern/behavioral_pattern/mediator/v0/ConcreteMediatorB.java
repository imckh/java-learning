package designpattern.behavioral_pattern.mediator.v0;

public class ConcreteMediatorB extends Mediator {
    //实现业务方法，封装同事之间的调用
    @Override
    public void operation() {
        ((Colleague) (colleagues.get(0))).method2(); //通过中介者调用同事类的方法
    }
}
