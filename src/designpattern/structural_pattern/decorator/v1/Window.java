package designpattern.structural_pattern.decorator.v1;

/**
 * <p>Description: 窗体类：具体构件类</p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:28
 */
public class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }
}

