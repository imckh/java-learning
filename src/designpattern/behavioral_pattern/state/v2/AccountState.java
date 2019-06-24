package designpattern.behavioral_pattern.state.v2;

/**
 * <p>Description: 抽象状态类</p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:19
 */
public abstract class AccountState {
    protected Account acc;

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void computeInterest();

    public abstract void stateCheck();
}
