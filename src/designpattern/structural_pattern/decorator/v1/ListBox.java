package designpattern.structural_pattern.decorator.v1;

/**
 * <p>Description: 列表框类</p>
 *
 * @author Cui Kaihui
 * @date 2019/5/13 23:29
 */
public class ListBox extends Component {
    @Override
    public void display() {
        System.out.println("显示列表框！");
    }
}
