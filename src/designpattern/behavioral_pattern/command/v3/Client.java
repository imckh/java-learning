package designpattern.behavioral_pattern.command.v3;

public class Client {
    public static void main(String args[]) {
        CalculatorForm form = new CalculatorForm();
        AbstractCommand command;

        command = new ConcreteCommand();
        form.setCommand(command); //向发送者注入命令对象
        form.compute(10);
        form.compute(5);
        form.compute(10);
        form.undo();
        /*
        执行运算，运算结果为：10
        执行运算，运算结果为：15
        执行运算，运算结果为：25
        执行撤销，运算结果为：15
         */
    }
}
