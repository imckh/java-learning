package designpattern.creational_pattern.simple_factory_pattern.v3;

import designpattern.creational_pattern.simple_factory_pattern.v2.Chart;
import designpattern.creational_pattern.simple_factory_pattern.v2.ChartFactory;

public class Client {
    public static void main(String args[]) {
        Chart chart;
        String type = XMLUtil.getChartType(); //读取配置文件中的参数
        chart = ChartFactory.getChart(type); //创建产品对象
        chart.display();
    }
}
