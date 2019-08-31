import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        // 列出指定目录的全部文件（包括隐藏文件）：
        String pathname = "D:" + File.separator;

        File f = new File(pathname);

        // 列出的不是完整路径
        for (String s : f.list()) {
            System.out.println(s);
        }

        // 如果想列出完整路径的话，需要使用listFiles.他返回的是File的数组
        for (File fi : f.listFiles()) {
            System.out.println(fi);
        }

        // 使用isDirectory判断一个指定的路径是否为目录

        for (File fi : f.listFiles()) {
            System.out.println(fi + " isDerectory=" + fi.isDirectory());
        }
    }
}