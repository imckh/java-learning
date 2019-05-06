package designpattern.creational_pattern.factory_method_pattern.v3;

import designpattern.util.XMLUtil;

public class Client {
    public static void main(String args[]) {
        /*
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory(); //可引入配置文件实现
        logger = factory.createLogger();
        logger.writeLog();
        */

        // 引入配置文件实现
        LoggerFactory factory;
        Logger logger;
        factory = (LoggerFactory) XMLUtil.getBean("creational_pattern.factory_method_pattern.v3"); //getBean()的返回类型为Object，需要进行强制类型转换
        if (factory != null) {
            logger = factory.createLogger();
            logger.writeLog();
        }
    }
}
