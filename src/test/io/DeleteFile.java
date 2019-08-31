import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        String fileName = "files" + File.separator + "hello.txt";
        File f = new File(fileName);

        if (f.exists()) {
            f.delete();
        } else {
            System.out.println("文件不存在");
        }
    }
}