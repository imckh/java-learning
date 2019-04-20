package designpattern.creational_pattern.prototype_pattern.v0;

public class ConcretePrototype2 implements Cloneable{
    @Override
    public Prototype clone()
    {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return (Prototype )object;
    }

}
