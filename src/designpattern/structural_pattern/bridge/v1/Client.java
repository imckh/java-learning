package designpattern.structural_pattern.bridge.v1;

import designpattern.util.XMLUtil;

public class Client {
    public static void main(String[] args) {
        Image image;
        ImageImp imp;
        image = (Image)XMLUtil.getBean("structural_pattern.bridge.v1.image");
        imp = (ImageImp) XMLUtil.getBean("structural_pattern.bridge.v1.os");
        image.setImageImp(imp);
        image.parseFile("小龙女");
        // 在Windows操作系统中显示图像：小龙女，格式为JPG。
    }
}
