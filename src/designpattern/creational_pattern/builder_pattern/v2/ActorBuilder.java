package designpattern.creational_pattern.builder_pattern.v2;

//角色建造器：抽象建造者
public abstract class ActorBuilder {
    protected static Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    //钩子方法
    public boolean isBareheaded() {
        return false;
    }

    // 还有一种更简单的处理方法，可以将construct()方法的参数去掉，
    // 直接在construct() 方法中调用buildPartX()方法
    public Actor constructRemoveDirector() {
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        //通过钩子方法来控制产品的构建
        if (!this.isBareheaded()) {
            this.buildHairstyle();
        }
        return actor;
    }
}
