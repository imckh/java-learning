package designpattern.behavioral_pattern.state.v2;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/24 22:22
 */
public class Client {
    public static void main(String args[]) {
        Account acc = new Account("段誉", 0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }

    /*
    段誉开户，初始金额为0.0
    ---------------------------------------------
    段誉存款1000.0
    现在余额为1000.0
    现在帐户状态为designpattern.behavioral_pattern.state.v2.NormalState
    ---------------------------------------------
    段誉取款2000.0
    现在余额为-1000.0
    现在帐户状态为designpattern.behavioral_pattern.state.v2.OverdraftState
    ---------------------------------------------
    段誉存款3000.0
    现在余额为2000.0
    现在帐户状态为designpattern.behavioral_pattern.state.v2.NormalState
    ---------------------------------------------
    段誉取款4000.0
    现在余额为-2000.0
    现在帐户状态为designpattern.behavioral_pattern.state.v2.RestrictedState
    ---------------------------------------------
    段誉取款1000.0
    帐号受限，取款失败
    现在余额为-2000.0
    现在帐户状态为designpattern.behavioral_pattern.state.v2.RestrictedState
    ---------------------------------------------
    计算利息！
     */
}
