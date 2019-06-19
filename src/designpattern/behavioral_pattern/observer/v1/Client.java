package designpattern.behavioral_pattern.observer.v1;

public class Client {
    public static void main(String args[]) {
        //定义观察目标对象
        AllyControlCenter acc;
        acc = new ConcreteAllyControlCenter("金庸群侠");
        //定义四个观察者对象
        Observer player1, player2, player3, player4;
        player1 = new Player("杨过");
        acc.join(player1);
        player2 = new Player("令狐冲");
        acc.join(player2);
        player3 = new Player("张无忌");
        acc.join(player3);
        player4 = new Player("段誉");
        acc.join(player4);
        //某成员遭受攻击
        player4.beAttacked(acc);

        /*
        金庸群侠战队组建成功！
        ----------------------------
        杨过加入金庸群侠战队！
        令狐冲加入金庸群侠战队！
        张无忌加入金庸群侠战队！
        段誉加入金庸群侠战队！
        段誉被攻击！
        金庸群侠战队紧急通知，盟友段誉遭受敌人攻击！
        坚持住，杨过来救你！
        坚持住，令狐冲来救你！
        坚持住，张无忌来救你！
         */
    }
}
