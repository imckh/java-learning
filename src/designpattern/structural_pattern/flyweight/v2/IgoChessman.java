package designpattern.structural_pattern.flyweight.v2;

/**
 * <p>Description: </p>
 * 围棋棋子类：抽象享元类
 *
 * @author Cui Kaihui
 * @date 2019/5/21 21:35
 */
public abstract class IgoChessman {
    public abstract String getColor();

    public void display(Coordinates coord) {
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coord.getX() + "，" + coord.getY());
    }
}
