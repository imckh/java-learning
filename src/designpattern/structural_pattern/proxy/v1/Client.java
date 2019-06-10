package designpattern.structural_pattern.proxy.v1;

import designpattern.util.XMLUtil;

public class Client {
    public static void main(String[] args) {
        Searcher searcher; //针对抽象建造者编程
        searcher = (Searcher) XMLUtil.getBean("structural_pattern.proxy.v1.proxy"); //反射生成具体建造者对象

        String result = searcher.DoSearch("杨过", "玉女心经");

        /*
        在数据库中验证用户'杨过'是否是合法用户？
        杨过登录成功！
        用户'杨过'使用关键词'玉女心经'查询商务信息！更新数据库，用户杨过查询次数加1！
         */
    }
}
