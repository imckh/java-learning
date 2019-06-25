package designpattern.behavioral_pattern.strategy.v2;

import designpattern.util.XMLUtil;

public class Client {
    public static void main(String args[]) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;
        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");
        Discount discount;
        discount = (Discount) XMLUtil.getBean("designpattern.behavioral_pattern.strategy.v2.Discount"); //读取配置文件并反射生成具体折扣对象
        mt.setDiscount(discount); //注入折扣对象
        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
        /*
        原始价为：60.0
        ---------------------------------
        学生票：
        折后价为：48.0
         */
    }
}
