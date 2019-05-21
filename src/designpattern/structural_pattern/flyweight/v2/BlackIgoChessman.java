package designpattern.structural_pattern.flyweight.v2;

/**
 * <p>Description: </p>
 * 黑色棋子类：具体享元类
 * @author Cui Kaihui
 * @date 2019/5/21 21:35
 */
public class BlackIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "黑色";
    }
}
