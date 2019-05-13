package designpattern.structural_pattern.decorator.v1;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:31
 */
public class Client {
    public static void main(String args[]) {
//        Component component, componentSB; //使用抽象构件定义
//        component = new Window(); //定义具体构件
//        componentSB = new ScrollBarDecorator(component); //定义装饰后的构件
//        componentSB.display();

        Component component, componentSB, componentBB; //全部使用抽象构件定义
        component = new Window();
        componentSB = new ScrollBarDecorator(component);
        componentBB = new BlackBorderDecorator(componentSB); //将装饰了一次之后的对象继续注入到另一个装饰类中，进行第二次装饰
        componentBB.display();
    }
}
