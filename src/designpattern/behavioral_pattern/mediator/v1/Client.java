package designpattern.behavioral_pattern.mediator.v1;

public class Client {
    public static void main(String args[]) {
        //定义中介者对象
        ConcreteMediator mediator;
        mediator = new ConcreteMediator();
        //定义同事对象
        Button addBT = new Button();
        List list = new List();
        ComboBox cb = new ComboBox();
        TextBox userNameTB = new TextBox();
        addBT.setMediator(mediator);
        list.setMediator(mediator);
        cb.setMediator(mediator);
        userNameTB.setMediator(mediator);
        mediator.addButton = addBT;
        mediator.list = list;
        mediator.cb = cb;
        mediator.userNameTextBox = userNameTB;
        addBT.changed();
        System.out.println("-----------------------------");
        list.changed();
        /*
        --单击增加按钮--
        列表框增加一项：张无忌。
        组合框增加一项：张无忌。
        客户信息增加成功后文本框清空。
        -----------------------------
        --从列表框选择客户--
        组合框选中项：小龙女。
        文本框显示：小龙女。
         */
    }
}
