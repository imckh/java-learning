package designpattern.creational_pattern.abstract_factory_pattern.v0;

public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示绿色边框文本框。");
    }
}
