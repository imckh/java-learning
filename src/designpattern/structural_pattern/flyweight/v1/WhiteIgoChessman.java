package designpattern.structural_pattern.flyweight.v1;

/**
 * <p>Description: </p>
 * 白色棋子类：具体享元类
 * @author Cui Kaihui
 * @date 2019/5/21 21:36
 */
public class WhiteIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "白色";
    }
}
