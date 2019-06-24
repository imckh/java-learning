package designpattern.behavioral_pattern.state.v3;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:30
 */
public class Client {
    public static void main(String args[]) {
        Switch s1, s2;
        s1 = new Switch("开关1");
        s2 = new Switch("开关2");
        s1.on();
        s2.on();
        s1.off();
        s2.off();
        s2.on();
        s1.on();
    }
/*
开关1已经打开！
开关2已经打开！
开关1关闭！
开关2已经关闭！
开关2打开！
开关1已经打开！
 */
}
