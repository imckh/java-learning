package designpattern.behavioral_pattern.visitor.v1;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/27 22:19
 */
public abstract class Department {
    //声明一组重载的访问方法，用于访问不同类型的具体元素
    public abstract void visit(FulltimeEmployee employee);

    public abstract void visit(ParttimeEmployee employee);
}
