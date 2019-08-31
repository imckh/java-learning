import java.io.File;

public class CreateFile {
    public static void main(String[] args) {
        File f = new File("files\\hello.txt");

        try {
            // 创建一个新文件
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}