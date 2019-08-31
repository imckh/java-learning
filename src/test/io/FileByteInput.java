import java.io.*;

public class FileByteInput {
    public static void main(String[] args) throws IOException {
        String pathname = "files" + File.separator + "FileByteInput.txt";
        File f = new File(pathname);

        // 查看hello.txt会看到“你好”
        // gbk的编码
        OutputStream out = new FileOutputStream(f);
        byte[] bytes = "你好".getBytes();
        out.write(bytes);

        // 向文件中一个字节一个字节的写入字符串
        for (int i = 0; i < bytes.length; i++) {
            out.write(bytes[i]);
        }

        out.close();
    }
}