package designpattern.structural_pattern.flyweight.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * 围棋棋子工厂类：享元工厂类，使用单例模式进行设计
 * @author Cui Kaihui
 * @date 2019/5/21 21:36
 */
public class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Map ht; //使用Hashtable来存储享元对象，充当享元池
    private IgoChessmanFactory() {
        ht = new HashMap();
        IgoChessman black,white;
        black = new BlackIgoChessman();
        ht.put("b",black);
        white = new WhiteIgoChessman();
        ht.put("w",white);
    }
    //返回享元工厂类的唯一实例
    public static IgoChessmanFactory getInstance() {
        return instance;
    }
    //通过key来获取存储在Hashtable中的享元对象
    public IgoChessman getIgoChessman(String color) {
        return (IgoChessman)ht.get(color);
    }

}
