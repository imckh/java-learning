package designpattern.behavioral_pattern.state.v4;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:37
 */
public class Client {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.onClick();
        screen.onClick();
        screen.onClick();
        /*
        正常大小！
        二倍大小！
        四倍大小！
        正常大小！
         */
    }
}
