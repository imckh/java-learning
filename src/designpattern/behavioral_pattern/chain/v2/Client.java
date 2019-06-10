package designpattern.behavioral_pattern.chain.v2;

public class Client {
    public static void main(String[] args) {
        Approver wjzhang, gyang, jguo, meeting, rhuang;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        jguo = new President("郭靖");
        rhuang = new Manager("黄蓉");

        meeting = new Congress("董事会");
        //创建职责链
        wjzhang.setSuccessor(rhuang); //将“黄蓉”作为“张无忌”的下家
        rhuang.setSuccessor(gyang); //将“杨过”作为“黄蓉”的下家
        //wjzhang.setSuccessor(gyang); 增加manager后  这句删掉
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);

        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        wjzhang.processRequest(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买《葵花宝典》");
        wjzhang.processRequest(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000, 10003, "购买《金刚经》");
        wjzhang.processRequest(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000, 10004, "购买桃花岛");
        wjzhang.processRequest(pr4);

        /*
        主任张无忌审批采购单：10001，金额：45000.0元，采购目的：购买倚天剑。
        副董事长杨过审批采购单：10002，金额：60000.0元，采购目的：购买《葵花宝典》。
        董事长郭靖审批采购单：10003，金额：160000.0元，采购目的：购买《金刚经》。
        召开董事会审批采购单：10004，金额：800000.0元，采购目的：购买桃花岛。
         */

        // 加入manager后
        /*
        主任张无忌审批采购单：10001，金额：45000.0元，采购目的：购买倚天剑。
        经理黄蓉审批采购单：10002，金额：60000.0元，采购目的：购买《葵花宝典》。
        董事长郭靖审批采购单：10003，金额：160000.0元，采购目的：购买《金刚经》。
        召开董事会审批采购单：10004，金额：800000.0元，采购目的：购买桃花岛。
         */
    }
}
