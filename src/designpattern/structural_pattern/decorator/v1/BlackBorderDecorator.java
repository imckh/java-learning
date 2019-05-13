package designpattern.structural_pattern.decorator.v1;

/**
 * <p>Description: 黑色边框装饰类：具体装饰类</p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:30
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }
}
