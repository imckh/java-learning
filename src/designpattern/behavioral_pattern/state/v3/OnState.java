package designpattern.behavioral_pattern.state.v3;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:29
 */
public class OnState extends State {
    @Override
    public void on(Switch s) {
        System.out.println("已经打开！");
    }

    @Override
    public void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));
    }

}
