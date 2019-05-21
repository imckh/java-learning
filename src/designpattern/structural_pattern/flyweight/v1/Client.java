package designpattern.structural_pattern.flyweight.v1;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/5/21 21:38
 */
public class Client {
    public static void main(String args[]) {
        IgoChessman black1,black2,black3,white1,white2;
        IgoChessmanFactory factory;
//获取享元工厂对象
        factory = IgoChessmanFactory.getInstance();
//通过享元工厂获取三颗黑子
        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));
//通过享元工厂获取两颗白子
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同：" + (white1==white2));
//显示棋子
        black1.display();
        black2.display();
        black3.display();
        white1.display();
        white2.display();
        /*
         判断两颗黑子是否相同：true
         判断两颗白子是否相同：true
         棋子颜色：黑色
         棋子颜色：黑色
         棋子颜色：黑色
         棋子颜色：白色
         棋子颜色：白色
         */
    }

}
