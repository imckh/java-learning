import java.io.File;

public class FileSeparator {
    public static void main(String[] args) throws Exception{
        // File类的两个常量
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        String fileName = "files" + File.separator + "hello.txt";

        File f = new File(fileName);
        f.createNewFile();
    }
}