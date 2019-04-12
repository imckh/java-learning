package designpattern.creational_pattern.simple_factory_pattern.v2;

//柱状图类：具体产品类
public class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("创建柱状图！");
    }
    public void display() {
        System.out.println("显示柱状图！");
    }
}
