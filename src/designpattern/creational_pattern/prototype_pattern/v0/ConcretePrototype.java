package designpattern.creational_pattern.prototype_pattern.v0;

public class ConcretePrototype implements Prototype {
    private String attr; //成员属性

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return this.attr;
    }

    public Prototype clone() //克隆方法
    {
        Prototype prototype = new ConcretePrototype(); //创建新对象
        prototype.setAttr(this.attr);
        return prototype;
    }
}
