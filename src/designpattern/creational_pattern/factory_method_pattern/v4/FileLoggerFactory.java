package designpattern.creational_pattern.factory_method_pattern.v4;

//文件日志记录器工厂类：具体工厂
public class FileLoggerFactory extends LoggerFactory {
    public Logger createLogger() {
        //使用默认方式创建文件日志，代码省略
        Logger logger = new FileLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }

    public Logger createLogger(String args) {
        //使用参数args作为连接字符串来创建文件日志，代码省略
        Logger logger = new FileLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }

    public Logger createLogger(Object obj) {
        //使用封装在参数obj中的连接字符串来创建文件日志，代码省略
        Logger logger = new FileLogger();
        //使用封装在参数obj中的数据来初始化数据库日志记录器，代码省略
        return logger;
    }
}