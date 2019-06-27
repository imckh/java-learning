package designpattern.behavioral_pattern.state.v2;

/**
 * <p>Description: 透支状态：具体状态类</p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:21
 */
public class OverdraftState extends AccountState {
    public OverdraftState(AccountState state) {
        this.acc = state.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance() - amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    //状态转换
    @Override
    public void stateCheck() {
        if (acc.getBalance() > 0) {
            acc.setState(new NormalState(this));
        } else if (acc.getBalance() == -2000) {
            acc.setState(new RestrictedState(this));
        } else if (acc.getBalance() < -2000) {
            System.out.println("操作受限！");
        }
    }
}