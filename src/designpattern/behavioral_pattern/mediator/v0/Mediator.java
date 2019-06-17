package designpattern.behavioral_pattern.mediator.v0;

import java.util.List;

public abstract class Mediator {
    protected List<Colleague> colleagues; //用于存储同事对象

    //注册方法，用于增加同事对象
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    //声明抽象的业务方法
    public abstract void operation();
}
