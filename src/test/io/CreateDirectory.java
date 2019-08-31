import java.io.File;

public class CreateDirectory {
    public static void main(String[] args) {
        String filename = "files" + File.separator + "hello";

        // 创建一个文件夹
        File f = new File(filename);
        f.mkdir();
    }
}