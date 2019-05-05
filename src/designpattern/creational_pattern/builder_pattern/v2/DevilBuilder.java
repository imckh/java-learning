package designpattern.creational_pattern.builder_pattern.v2;

public class DevilBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }

    // 如果某个角色无须构建头发部件，例如“恶魔(Devil)”，
    // 则对应的具体建造器DevilBuilder将覆盖isBareheaded()方法，并将返回值改为true
    //覆盖钩子方法
    @Override
    public boolean isBareheaded() {
        return true;
    }
}
