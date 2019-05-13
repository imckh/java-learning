package designpattern.structural_pattern.decorator.v1;

/**
 * <p>Description: 文本框</p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:28
 */
public class TextBox extends Component {
    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}
