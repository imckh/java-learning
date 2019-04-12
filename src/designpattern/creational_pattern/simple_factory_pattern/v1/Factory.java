package designpattern.creational_pattern.simple_factory_pattern.v1;

public class Factory {
    //静态工厂方法
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProduct();
//初始化设置product
        }
        else if (arg.equalsIgnoreCase("B")) {
            //product = new ConcreteProductB();
//初始化设置product
        }
        return product;
    }
}
