package designpattern.creational_pattern.factory_method_pattern.v4;

//数据库日志记录器：具体产品
public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}
