package designpattern.behavioral_pattern.state.v4;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:35
 */
public class NormalState extends State {
    @Override
    public void display() {
        System.out.println("正常大小！");
    }
}
