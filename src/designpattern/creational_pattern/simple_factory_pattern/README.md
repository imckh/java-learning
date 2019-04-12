# 六个创建型模式

## 简单工厂模式

对象的创建和对象的使用分离开

### simple_factory_pattern_v1

所有图表的实现代码封装在一个Chart类中

简单工厂模式举例

### simple_factory_pattern_v2

将Chart类的职责分离，同时将Chart对象的创建和使用分离

Chart接口充当抽象产品类，其子类HistogramChart、PieChart和LineChart充当具体产品类，ChartFactory充当工厂类

### simple_factory_pattern_v2

将静态工厂方法的参数存储在XML或properties格式的配置文件中

更换具体图表对象，只需修改配置文件config.xml，无须修改任何源代码