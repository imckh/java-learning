package designpattern.behavioral_pattern.command.v4;

//增加命令类：具体命令
public class InsertCommand extends Command {
    public InsertCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }

    public void execute() {
        configOperator.insert(this.args);
    }
}