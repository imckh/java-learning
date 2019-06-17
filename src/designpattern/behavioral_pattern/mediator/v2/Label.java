package designpattern.behavioral_pattern.mediator.v2;

import designpattern.behavioral_pattern.mediator.v1.Component;

public class Label extends Component {
    @Override
    public void update() {
        System.out.println("文本标签内容改变，客户信息总数加1。");
    }
}