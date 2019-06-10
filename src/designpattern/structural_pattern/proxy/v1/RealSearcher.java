package designpattern.structural_pattern.proxy.v1;

public class RealSearcher implements Searcher {
    @Override
    //模拟查询商务信息
    public String DoSearch(String userId, String keyword) {
        System.out.printf("用户'%s'使用关键词'%s'查询商务信息！",userId,keyword);
        return "返回具体内容";
    }
}
