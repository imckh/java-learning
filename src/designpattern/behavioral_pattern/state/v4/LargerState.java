package designpattern.behavioral_pattern.state.v4;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:36
 */
public class LargerState extends State {

    @Override
    public void display() {
        System.out.println("二倍大小！");
    }
}
