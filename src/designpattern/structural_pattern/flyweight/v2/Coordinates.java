package designpattern.structural_pattern.flyweight.v2;

/**
 * <p>Description: </p>
 * 坐标类：外部状态类
 *
 * @author Cui Kaihui
 * @date 2019/5/21 21:44
 */
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
