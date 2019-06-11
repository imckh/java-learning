package designpattern.behavioral_pattern.command.v1;

import designpattern.util.XMLUtil;

public class Client {
    public static void main(String args[]) {
        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");
        FunctionButton fb1, fb2;
        fb1 = new FunctionButton("功能键1");
        fb2 = new FunctionButton("功能键1");
        Command command1, command2;
        //通过读取配置文件和反射生成具体命令对象
        command1 = (Command) XMLUtil.getBean("behavioral_pattern.command.v1.HelpCommand");
        command2 = (Command) XMLUtil.getBean("behavioral_pattern.command.v1.MinimizeCommand");

        //将命令对象注入功能键
        fb1.setCommand(command1);
        fb2.setCommand(command2);

        fbsw.addFunctionButton(fb1);
        fbsw.addFunctionButton(fb2);
        fbsw.display();
        //调用功能键的业务方法
        fb1.onClick();
        fb2.onClick();

        /*
        显示窗口：功能键设置
        显示功能键：
        功能键1
        功能键1
        ------------------------------
        点击功能键：显示帮助文档！
        点击功能键：将窗口最小化至托盘！
         */
    }
}
