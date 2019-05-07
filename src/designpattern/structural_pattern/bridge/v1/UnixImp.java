package designpattern.structural_pattern.bridge.v1;

public class UnixImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        //调用Unix系统的绘制函数绘制像素矩阵
        System.out.print("在Unix操作系统中显示图像：");
    }
}
