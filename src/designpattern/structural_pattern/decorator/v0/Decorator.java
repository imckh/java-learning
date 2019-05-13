package designpattern.structural_pattern.decorator.v0;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:10
 */
public class Decorator implements Component {
    private Component component; //维持一个对抽象构件对象的引用

    public Decorator(Component component) //注入一个抽象构件类型的对象
    {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation(); //调用原有业务方法
    }
}