package designpattern.creational_pattern.builder_pattern.v1;

//角色建造器：抽象建造者
public abstract class ActorBuilder {
    protected static Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    //工厂方法，返回一个完整的游戏角色对象
//    public Actor createActor() {
//        return actor;
//    }

    public static Actor construct(ActorBuilder ab) {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        return actor;
    }

    // 还有一种更简单的处理方法，可以将construct()方法的参数去掉，
    // 直接在construct() 方法中调用buildPartX()方法
    public Actor constructRemoveDirector() {
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairstyle();
        return actor;
    }
}
