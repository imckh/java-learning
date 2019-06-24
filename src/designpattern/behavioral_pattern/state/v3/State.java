package designpattern.behavioral_pattern.state.v3;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:29
 */
public abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}
