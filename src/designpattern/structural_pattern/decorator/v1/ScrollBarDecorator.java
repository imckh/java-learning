package designpattern.structural_pattern.decorator.v1;

/**
 * <p>Description: 滚动条装饰类：具体装饰类</p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:30
 */
public class ScrollBarDecorator extends ComponentDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }
}
