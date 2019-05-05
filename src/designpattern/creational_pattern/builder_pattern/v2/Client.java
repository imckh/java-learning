package designpattern.creational_pattern.builder_pattern.v2;

public class Client {
    public static void main(String[] args) {
        ActorBuilder ab; //针对抽象建造者编程
        ab = (ActorBuilder) XMLUtil.getBean(); //反射生成具体建造者对象
        Actor actor;

        System.out.println("========================");
        // 方法2 可以将construct()方法的参数去掉，直接在construct()方法中调用buildPartX()方法
        actor = ab.constructRemoveDirector();
        String type = actor.getType();
        System.out.println(type + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());

        /*
        天使的外观：
        性别：女
        面容：漂亮
        服装：白裙
        发型：披肩长发

        ========================
        恶魔的外观：
        性别：妖
        面容：丑陋
        服装：黑衣
        发型：null
         */
    }
}
