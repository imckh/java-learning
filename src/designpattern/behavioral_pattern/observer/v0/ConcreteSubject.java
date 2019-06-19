package designpattern.behavioral_pattern.observer.v0;

public class ConcreteSubject extends Subject {
    //实现通知方法
    @Override
    public void notifyObs() {
        //遍历观察者集合，调用每一个观察者的响应方法
        for (Object obs : observers) {
            ((Observer) obs).update();
        }
    }
}
