package designpattern.creational_pattern.factory_method_pattern.v4;

import designpattern.util.XMLUtil;

public class Client {
    public static void main(String[] args) {
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean("creational_pattern.factory_method_pattern.v4"); //getBean()的返回类型为Object，需要进行强制类型转换
        if (factory != null) {
            factory.writeLog(); //直接使用工厂对象来调用产品对象的业务方法
        }
    }
}
